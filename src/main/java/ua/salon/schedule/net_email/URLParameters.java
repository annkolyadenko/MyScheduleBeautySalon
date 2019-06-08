package ua.salon.schedule.net_email;

import ua.salon.schedule.utils.IPDefiner;

public enum URLParameters {
    PROTOCOL("http://"), IP(IPDefiner.defineIP()), PORT(":8080/");

    private String value;

    URLParameters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getURLParameters() {
        return PROTOCOL.getValue() + IP.getValue() + PORT.getValue();
    }
}
