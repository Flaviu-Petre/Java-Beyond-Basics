package org.example;

import Interfaces.EventServiceInterface;
import Service.EventServiceImpl;
import models.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventServiceInterface eventService = new EventServiceImpl();

        eventService.createEvent(LocalDateTime.now());
        eventService.createEvent(LocalDateTime.now().plusHours(1));
        eventService.createEvent(LocalDateTime.now().plusDays(1));

        List <Event> events = new ArrayList<>();
        events = eventService.listAllEventsScheduledForAGivenDate(LocalDateTime.now().plusDays(1));

        System.out.println("Events found");
        for (Event event : events) {
            System.out.println(event.getEventName());
        }

//        System.out.println("Is Clashing: " + eventService.isNewEventClashingWithExistingEvents(LocalDateTime.now().plusMinutes(30), LocalDateTime.now().plusHours(2)));

        System.out.println("Find next available slot for 30 minutes: " + eventService.findNextAvailableSlot(LocalDateTime.now(), 30));
    }
}