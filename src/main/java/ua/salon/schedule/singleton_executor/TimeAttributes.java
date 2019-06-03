package ua.salon.schedule.singleton_executor;

public enum TimeAttributes {
    SCHEDULED_HOUR(19), SCHEDULED_MINUTE(54),SCHEDULED_SECONDS(0);

    private int value;

    TimeAttributes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
