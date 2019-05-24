package ua.salon.schedule.command;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.model.booking.Booking;
import ua.salon.schedule.services.BookingService;
import ua.salon.schedule.services.service_factory.ServiceFactory;

import java.util.List;
import java.util.Observable;

///**@Deprecated(since="9") see:https://docs.oracle.com/javase/9/docs/api/java/util/Observable.html*/

public class GetAllBookingsByDayCommand extends Observable {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private BookingService bookingService;


    public GetAllBookingsByDayCommand() {
        bookingService = ServiceFactory.getBookingService();
    }

    public void/*List<Booking>*/ invokeDAO(String date) {
        List<Booking> result = bookingService.getAllBookingsByDate(date);
        for (Booking booking : result) {
            System.out.println(booking.getClient().getEmail());
        }
        setChanged();
        /*notifyObservers(result);*/
        String string = "I did it";
        notifyObservers(string);
        rootLogger.debug("Observer MailClient.class was notified");
        /*return result;*/
    }
}
