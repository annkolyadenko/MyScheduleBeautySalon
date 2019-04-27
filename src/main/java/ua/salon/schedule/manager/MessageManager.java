package ua.salon.schedule.manager;

import java.util.ResourceBundle;

public class MessageManager {
    private final static ResourceBundle resourseBundle = ResourceBundle.getBundle("resources.messages");
    private MessageManager() { }
    public static String getProperty(String key) {
        return resourseBundle.getString(key);
    }
}



