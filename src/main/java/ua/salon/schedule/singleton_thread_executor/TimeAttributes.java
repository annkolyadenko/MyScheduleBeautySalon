package ua.salon.schedule.singleton_thread_executor;

public enum TimeAttributes {
    SCHEDULED_HOUR(14), SCHEDULED_MINUTE(15),SCHEDULED_SECONDS(0);

    private int value;

    TimeAttributes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
