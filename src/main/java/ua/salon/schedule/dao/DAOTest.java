package ua.salon.schedule.dao;

import ua.salon.schedule.connection_utils.connection_exceptions.ConnectionNotOpenedException;
import ua.salon.schedule.dao.review.ReviewDAO;
import ua.salon.schedule.model.review.Review;

import java.sql.SQLException;
import java.util.List;

public class DAOTest {

    public static void main(String[] args) throws SQLException, ConnectionNotOpenedException {
        /*UserDAO userDAO = new UserDAO();
        User master1 = userDAO.findUserById(25);
        User client1 = userDAO.findUserById(20);
        User client2 = userDAO.findUserById(24);
        User client3 = userDAO.findUserById(27);
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        Booking booking3 = new Booking();
        booking1.setMaster(master1);
        booking2.setMaster(master1);
        booking3.setMaster(master1);
        booking1.setClient(client1);
        booking2.setClient(client2);
        booking3.setClient(client3);
        booking1.setTimeSlotStart(LocalDateTime.of(2018, 5, 30, 8, 0));
        booking2.setTimeSlotStart(LocalDateTime.of(2018, 5, 30, 9, 0));
        booking3.setTimeSlotStart(LocalDateTime.of(2018, 5, 30, 10, 0));
        booking1.setTimeSlotEnd(LocalDateTime.of(2018, 5, 30, 9, 0));
        booking2.setTimeSlotEnd(LocalDateTime.of(2018, 5, 30, 10, 0));
        booking3.setTimeSlotEnd(LocalDateTime.of(2018, 5, 30, 11, 0));
        System.out.println(booking1);
        System.out.println(booking2);
        System.out.println(booking3);*/
        /*System.out.println(TimeUtil.addTimeGap("8:00"));*/
        /*String str1 = "1986-01-21";
        String str2 = "8:30";
        String str3 = TimeUtil.addTimeGap(str2);
        System.out.println(str3);
        LocalDateTime dateTime = LocalDateTime.parse(str1+" "+str2, Formatter.getFormatter());
        System.out.println(dateTime);*/
        /*BookingDAO bookingDAO = new BookingDAO();
        List<Booking> bookingsForToday = bookingDAO.getAllBookingsByDate(LocalDate.now().toString());*/
        /*GetAllBookingsByDayCommand command = new GetAllBookingsByDayCommand();
                command.invokeDAO(LocalDate.now().toString());*/
       /* ReviewDAO dao = new ReviewDAO();
        List<Review> reviewList = dao.getReviewByBookingId(71);
        System.out.println(reviewList);*/

    }
}


