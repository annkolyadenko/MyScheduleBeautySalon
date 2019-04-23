package main.schedule.dao;

import main.schedule.model.booking.Booking;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeConverter {

    public static Timestamp getConvertedTimeSlotStart(Booking booking) {
        LocalDateTime ldtStart = booking.getTimeSlotStart();
        Timestamp timeStampStart = Timestamp.valueOf(ldtStart);
        return new Timestamp(timeStampStart.getTime());
    }

    public static Timestamp getConvertedTimeSlotEnd(Booking booking) {
        LocalDateTime ldtEnd = booking.getTimeSlotEnd();
        Timestamp timeStampEnd = Timestamp.valueOf(ldtEnd);
        return new Timestamp(timeStampEnd.getTime());
    }
}
