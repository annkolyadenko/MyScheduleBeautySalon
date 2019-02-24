package ua.salon.schedule.model.booking;

import ua.salon.schedule.dao.user.UserDAO;
import ua.salon.schedule.model.user.User;

public class BookingTableTest {
    public static void main(String[] args) {
        BookingTable bookingTable = new BookingTable();
        UserDAO userDAO = new UserDAO();
        User client = userDAO.findUserById(2);
        bookingTable.printValues();


    }
}
