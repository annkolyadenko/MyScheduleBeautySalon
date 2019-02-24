package ua.salon.schedule.manager;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private final static ResourceBundle resourseBundle = ResourceBundle.getBundle("config");
    private ConfigurationManager() { }
    public static String getProperty(String key) {
        return resourseBundle.getString(key);
    }
}
