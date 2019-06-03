package ua.salon.schedule.singleton_executor;

public enum TimeAttributes {
    SCHEDULED_HOUR(18), SCHEDULED_MINUTE(8),SCHEDULED_SECONDS(0);

    private int value;

    TimeAttributes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
