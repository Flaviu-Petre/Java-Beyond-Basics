package Interfaces;

import models.Event;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface EventServiceInterface {
    void createEvent(LocalDateTime startDate);
    List<Event> listAllEventsScheduledForAGivenDate(LocalDateTime date);
    boolean isNewEventClashingWithExistingEvents(LocalDateTime startDate, LocalDateTime endDate);
    LocalTime findNextAvailableSlot(LocalDateTime date, int durationInMinutes);
    void rescheduleEvent(Event event, LocalDateTime newStartDate, LocalDateTime newEndDate);
    void cancelEvent(Event event);
}
