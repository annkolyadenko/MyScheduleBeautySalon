package main.schedule.dao.review;

import org.apache.logging.log4j.*;
import main.schedule.connection_utils.DatasourceJNDI;
import main.schedule.dao.booking.BookingDAO;
import main.schedule.dao.user.UserDAO;
import main.schedule.model.booking.Booking;
import main.schedule.model.review.Review;
import main.schedule.model.user.User;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO  {

    private Connection connection;
    /**
     * Define a static logger variable so that it references the Logger instance named "RootLogger".
     */
    private static final Logger rootLogger = LogManager.getRootLogger();

    private static final String FIND_REVIEW_BY_MASTER_ID = "SELECT * FROM reviews, booking WHERE reviews.review_booking_id = booking.booking_id AND booking_master_id = ?";
    private static final String ADD_REVIEW = "INSERT INTO reviews (review_text, review_booking_id) VALUES (?,?)";

    public void addReview(Review review) {
        PreparedStatement ps = null;
        try {
            connection = DatasourceJNDI.getConnection();
            rootLogger.debug("Check");
            ps = connection.prepareStatement(ADD_REVIEW);
            ps.setString(1, review.getText());
            int bookingId = review.getBooking().getBookingId();
            ps.setInt(2, bookingId);
            ps.executeUpdate();
        } catch (SQLException e) {
            rootLogger.warn("SQLException in adding user to database", e);
        } finally {
            /*try {
                DatasourceJNDI.closeConnection(connection, ps);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }*/
        }
    }

    public List<Review> getReviewsByMasterID(int masterId) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        BookingDAO bookingDAO = new BookingDAO();
        UserDAO userDao = new UserDAO();
        Booking booking = new Booking();
        User master = null;
        User client = null;
        Review review = new Review();
        LocalDateTime timeSlotStart = null;
        LocalDateTime timeSlotEnd = null;
        String text = null;
        List<Review> reviewsList = new ArrayList<>();
        int bookingId = 0;
        int clientId = 0;
        int reviewId = 0;
        try {
            connection = DatasourceJNDI.getConnection();
            ps = connection.prepareStatement(FIND_REVIEW_BY_MASTER_ID);
            ps.setInt(1, masterId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reviewId = rs.getInt("review_id");
                text = rs.getString("review_text");
                bookingId = rs.getInt("review_booking_id");
                Timestamp mySqlStart = rs.getTimestamp("schedule_slot_start");
                Timestamp mySqlEnd = rs.getTimestamp("schedule_slot_end");
                master = userDao.findUserById(masterId);
                booking = bookingDAO.getBookingById(bookingId);
                clientId = booking.getClient().getId();
                client = userDao.findUserById(clientId);
                timeSlotStart = mySqlStart.toLocalDateTime();
                timeSlotEnd = mySqlEnd.toLocalDateTime();
                booking.setBookingId(bookingId);
                booking.setMaster(master);
                booking.setClient(client);
                booking.setTimeSlotStart(timeSlotStart);
                booking.setTimeSlotEnd(timeSlotEnd);
                review.setId(reviewId);
                review.setText(text);
                review.setBooking(booking);
                reviewsList.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           /* try {
                DatasourceJNDI.closeConnection(connection, ps, resultSet);
            }  catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }*/
        }
        return reviewsList;
    }
}
