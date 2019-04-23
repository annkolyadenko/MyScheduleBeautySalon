package main.schedule.services;

import main.schedule.dao.booking.BookingDAO;
import main.schedule.model.booking.Booking;

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

    public Booking getBookingById(int bookingId) {
        return bookingDAO.getBookingById(bookingId);
    }
}
