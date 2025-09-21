package Service;

import Interfaces.EventServiceInterface;
import models.Event;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventServiceImpl implements EventServiceInterface {
    private static Integer eventId = 1;
    private List<Event> events = new ArrayList<>();


    @Override
    public void createEvent(LocalDateTime startDate) {
        Event event = new Event();

        event.setStartDate(startDate);
        event.setEventName("New Event " + eventId);
        eventId++;
        event.setEndDate(startDate.plusHours(1));
        event.setTimeZone(ZoneId.systemDefault());
        event.setRecurring(false);
        event.setRecurrenceInterval(Duration.ZERO);

        events.add(event);
        System.out.println("New Event Created");

    }

    @Override
    public List<Event> listAllEventsScheduledForAGivenDate(LocalDateTime date) {
        List<Event> eventsForGivenDAte = new ArrayList<>();

        events.stream().filter(event -> event.getStartDate().toLocalDate().isEqual(date .toLocalDate()))
                .forEach(eventsForGivenDAte::add);

        return eventsForGivenDAte;
    }

    @Override
    public boolean isNewEventClashingWithExistingEvents(LocalDateTime startDate, LocalDateTime endDate) {
        return events.stream().anyMatch(event ->
                startDate.isBefore(event.getEndDate()) && endDate.isAfter(event.getStartDate())
        );
    }


    public List<Event> getEvents() {
        return new ArrayList<>(events);
    }

    @Override
    public LocalTime findNextAvailableSlot(LocalDateTime date, int durationInMinutes) {
        return findNextAvailableSlot(date, durationInMinutes, 9, 17); // Default business hours 9 AM to 5 PM
    }

    public LocalTime findNextAvailableSlot(LocalDateTime date, int durationInMinutes,
                                           int startHour, int endHour) {
        LocalDate targetDate = date.toLocalDate();

        List<Event> dayEvents = events.stream()
                .filter(event -> event.getStartDate().toLocalDate().equals(targetDate))
                .sorted((e1, e2) -> e1.getStartDate().compareTo(e2.getStartDate()))
                .collect(Collectors.toList());

        LocalDateTime businessStart = targetDate.atTime(startHour, 0);
        LocalDateTime businessEnd = targetDate.atTime(endHour, 0);
        LocalDateTime currentTime = businessStart;

        if (dayEvents.isEmpty()) {
            return businessStart.toLocalTime();
        }

        LocalDateTime firstEventStart = dayEvents.get(0).getStartDate();
        if (currentTime.plusMinutes(durationInMinutes).isBefore(firstEventStart) ||
                currentTime.plusMinutes(durationInMinutes).isEqual(firstEventStart)) {
            return currentTime.toLocalTime();
        }

        for (int i = 0; i < dayEvents.size() - 1; i++) {
            LocalDateTime currentEventEnd = dayEvents.get(i).getEndDate();
            LocalDateTime nextEventStart = dayEvents.get(i + 1).getStartDate();

            // Check if there's enough gap between current and next event
            if (Duration.between(currentEventEnd, nextEventStart).toMinutes() >= durationInMinutes) {
                return currentEventEnd.toLocalTime();
            }
        }

        LocalDateTime lastEventEnd = dayEvents.get(dayEvents.size() - 1).getEndDate();
        if (lastEventEnd.plusMinutes(durationInMinutes).isBefore(businessEnd) ||
                lastEventEnd.plusMinutes(durationInMinutes).isEqual(businessEnd)) {
            return lastEventEnd.toLocalTime();
        }

        return null;
    }

    @Override
    public void rescheduleEvent(Event event, LocalDateTime newStartDate, LocalDateTime newEndDate) {
        event.setStartDate(newStartDate);
        event.setEndDate(newEndDate);
    }

    @Override
    public void cancelEvent(Event event) {
        events.remove(event);
    }
}
