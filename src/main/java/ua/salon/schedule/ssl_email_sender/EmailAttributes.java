package ua.salon.schedule.ssl_email_sender;

import ua.salon.schedule.command.jsp_pages.PagesJSP;
import ua.salon.schedule.net.IPDefiner;

public enum EmailAttributes {

    USERNAME("ann.lubska@gmail.com"), PASSWORD("2204071anna"), SUBJECT("feedback proposal"),
    TEXT("Please, leave us your feedback: http://"), IP(IPDefiner.defineIP()), PORT(":8084/"), JSP_PAGE("controller?command=FEEDBACK&bookingId=19&bookingDate=2018-05-30&bookingTime=08:00:00&masterName=Yura&userName=U2"), FROM_EMAIL("ann.lubska@gmail.com");

    private String value;

    EmailAttributes(String parameter) {
        value = parameter;
    }

    public String getValue() {
        return value;
    }
}
