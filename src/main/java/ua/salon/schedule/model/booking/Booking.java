package main.schedule.model.booking;

import main.schedule.model.user.User;
import main.schedule.model.user.UserRole;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Booking {
    private int bookingId;
    private User master;
    private User client;
    private LocalDateTime timeSlotStart;
    private LocalDateTime timeSlotEnd;

    public Booking() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        if (master.getRole().equals(UserRole.MASTER))
        this.master = master;
    }

    public LocalDateTime getTimeSlotStart() {
        return timeSlotStart;
    }

    public Integer getTime(){
        return timeSlotStart.getHour();
    }

    public void setTimeSlotStart(LocalDateTime timeSlotStart) {
        this.timeSlotStart = timeSlotStart;
    }

    public LocalDateTime getTimeSlotEnd() {
        return timeSlotEnd;
    }

    public void setTimeSlotEnd(LocalDateTime timeSlotEnd) {
        this.timeSlotEnd = timeSlotEnd;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        if (client.getRole().equals(UserRole.CLIENT))
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId &&
                Objects.equals(master, booking.master) &&
                Objects.equals(client, booking.client) &&
                Objects.equals(timeSlotStart, booking.timeSlotStart) &&
                Objects.equals(timeSlotEnd, booking.timeSlotEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, master, client, timeSlotStart, timeSlotEnd);
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public String toString() {

        return "Booking{" +
                "bookingId=" + bookingId +
                ", master=" + master.getName() +
                ", client=" + client.getName() +
                ", "+ timeSlotStart.format(formatter) +
                " - " + timeSlotEnd.format(formatter) +
                '}';
    }
}
