package ua.salon.schedule.command;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.model.booking.Booking;
import ua.salon.schedule.services.BookingService;
import ua.salon.schedule.services.service_factory.ServiceFactory;

import java.util.List;

public class GetAllBookingsByDayCommand implements Observable {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private BookingService bookingService;

    public GetAllBookingsByDayCommand() {
        bookingService = ServiceFactory.getBookingService();
    }

    public List<Booking> invokeDAO(String date) {
        List<Booking> result = bookingService.getAllBookingsByDate(date);
        for (Booking booking : result) {
            System.out.println(booking.getClient().getEmail());
        }
        return result;
    }

    @Override
    public void addListener(InvalidationListener listener) {
        //some code
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        //some code
    }
}
