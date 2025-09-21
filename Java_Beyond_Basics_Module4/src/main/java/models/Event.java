package models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Event {
    //region Fields
    private String eventName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ZoneId timeZone;
    private boolean recurring;
    private Duration recurrenceInterval;
    //endregion

    //region Constructors
    public Event(String eventName, LocalDateTime startDate, LocalDateTime endDate, ZoneId timeZone, boolean recurring, Duration recurrenceInterval) {
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeZone = timeZone;
        this.recurring = recurring;
        this.recurrenceInterval = recurrenceInterval;
    }

    public Event() {}
    //endregion

    //region Getters

    public String getEventName() {
        return eventName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public Duration getRecurrenceInterval() {
        return recurrenceInterval;
    }

    //endregion

    //region Setters

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public void setRecurrenceInterval(Duration recurrenceInterval) {
        this.recurrenceInterval = recurrenceInterval;
    }

    //endregion
}
