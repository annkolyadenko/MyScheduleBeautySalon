package ua.salon.schedule;

import ua.salon.schedule.dao.booking.BookingDAO;
import ua.salon.schedule.singleton_executor.ScheduledExecutor;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /*ScheduledGetAllBookingsCommandInvoker.threadInvoke();*/
        BookingDAO dao = new BookingDAO();
        dao.getAllBookingsByDate(LocalDate.now().toString());
        /*ScheduledGetAllBookingsCommandInvoker.threadInvoke();*/
        /*ScheduledGetAllBookingsCommandInvoker invoker = new ScheduledGetAllBookingsCommandInvoker();
        invoker.threadInvoke();*/
        ScheduledExecutor.GET_ALL_BOOKINGS_COMMAND_INVOKER.threadInvoke();
    }
}
