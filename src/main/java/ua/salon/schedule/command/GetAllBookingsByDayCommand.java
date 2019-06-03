package ua.salon.schedule.command;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.model.booking.Booking;
import ua.salon.schedule.services.BookingService;
import ua.salon.schedule.services.service_factory.ServiceFactory;

import java.util.Collections;
import java.util.List;
import java.util.Observable;

///**@Deprecated(since="9") see:https://docs.oracle.com/javase/9/docs/api/java/util/Observable.html*/

public class GetAllBookingsByDayCommand extends Observable {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private BookingService bookingService;

    public GetAllBookingsByDayCommand() {
        bookingService = ServiceFactory.getBookingService();
    }

    public void invokeDAO(String date) {
        List<Booking> result = Collections.EMPTY_LIST;
        result = bookingService.getAllBookingsByDate(date);
        for (Booking booking : result) {
            System.out.println(booking.getClient().getEmail());
        }
        if (!result.isEmpty()){
            setChanged();
            notifyObservers(result);
            rootLogger.debug("Observer MailClient.class was notified");
        }
    }
}
