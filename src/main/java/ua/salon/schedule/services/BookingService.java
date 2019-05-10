package ua.salon.schedule.services;

import ua.salon.schedule.dao.booking.BookingDAO;
import ua.salon.schedule.model.booking.Booking;

import java.util.List;

public class BookingService {
    private BookingDAO bookingDAO;

    public BookingService() {
        bookingDAO = new BookingDAO();
    }

    public void addBooking(Booking booking) {
        bookingDAO.addBooking(booking);
    }

    public List<Booking> getAllBookingsByMasterIdAndDate(int masterId, String date) /*throws ConnectionNotOpenedException*/ {
        return bookingDAO.getAllBookingsByMasterIdAndDate(masterId, date);
    }

    public List<Booking> getAllBookingsByDate(String date) {
        return bookingDAO.getAllBookingsByDate(date);
    }

    public Booking getBookingById(int bookingId) {
        return bookingDAO.getBookingById(bookingId);
    }
}
