package ua.salon.schedule.net_email;

public enum EmailAttributes {

    USERNAME("ann.lubska@gmail.com"), PASSWORD("2204071anna"), SUBJECT("feedback proposal"),
    TEXT("Please, leave us your feedback: "), FROM_EMAIL("ann.lubska@gmail.com");

    private String value;

    EmailAttributes(String parameter) {
        value = parameter;
    }

    public String getValue() {
        return value;
    }
}
