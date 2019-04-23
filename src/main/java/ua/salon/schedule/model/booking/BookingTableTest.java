package main.schedule.model.booking;

import main.schedule.dao.user.UserDAO;
import main.schedule.model.user.User;

public class BookingTableTest {
    public static void main(String[] args) {
        BookingTable bookingTable = new BookingTable();
        UserDAO userDAO = new UserDAO();
        User client = userDAO.findUserById(2);
        bookingTable.printValues();


    }
}
