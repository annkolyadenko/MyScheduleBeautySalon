package ua.salon.schedule;

import ua.salon.schedule.dao.booking.BookingDAO;
import ua.salon.schedule.singleton_executor.ScheduledExecutor;
import ua.salon.schedule.ssl_email_sender.MailClient;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /*ScheduledGetAllBookingsCommandInvoker.threadInvoke();*/
        BookingDAO dao = new BookingDAO();
        dao.getAllBookingsByDate(LocalDate.now().toString());
        /*ScheduledGetAllBookingsCommandInvoker.threadInvoke();*/
        /*ScheduledGetAllBookingsCommandInvoker invoker = new ScheduledGetAllBookingsCommandInvoker();
        invoker.threadInvoke();*/
        ScheduledExecutor.INSTANCE.threadInvoke();
    }
}
