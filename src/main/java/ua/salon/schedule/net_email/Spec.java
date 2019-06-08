package ua.salon.schedule.net_email;

import ua.salon.schedule.model.booking.Booking;

public enum Spec {
    COMMAND("controller?command=FEEDBACK"), BOOKING_ID("&bookingId="), BOOKING_DATE("&bookingDate="), BOOKING_TIME("&bookingTime="), MASTER_NAME("&masterName="), USER_NAME("&userName=");

    private String value;

    Spec(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static String getURLSpec(Booking booking) {
        return COMMAND.getValue()
                + BOOKING_ID.getValue() + booking.getBookingId()
                + BOOKING_DATE.getValue() + booking.getDateFormatter()
                + BOOKING_TIME.getValue() + booking.getTimeFormatter()
                + MASTER_NAME.getValue() + booking.getMaster().getName()
                + USER_NAME.getValue() + booking.getClient().getName();
    }
}
