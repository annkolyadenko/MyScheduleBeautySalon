package ua.salon.schedule.ssl_email_sender;

import ua.salon.schedule.net.IPDefiner;

public enum EmailAttributes {
    USERNAME("ann.lubska@gmail.com"), PASSWORD("2204071anna"), SUBJECT("feedback proposal"),
    TEXT("Please, leave us your feedback: "), LINK(IPDefiner.defineIP()+":8084/jsp/common/booking.jsp"), FROM_EMAIL("ann.lubska@gmail.com");

    private String value;

    EmailAttributes(String parameter) {
        value = parameter;
    }

    public String getValue() {
        return value;
    }
}
