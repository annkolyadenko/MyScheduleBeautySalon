package ua.salon.schedule.useful_utils;

import java.time.format.DateTimeFormatter;

public class Formatter {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }
}
