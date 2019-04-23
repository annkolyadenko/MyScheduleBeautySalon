package main.schedule.model.booking;

import main.schedule.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookingTableMap {
    private Map<Booking, List<User>> bookingTable;

    public BookingTableMap() {
        bookingTable = new TreeMap<>((o1, o2) -> 0);
    }

    public Map<Booking, List<User>> getBookingTable() {
        return bookingTable;
    }

    public void setBookingTable(Map<Booking, List<User>> bookingTable) {
        this.bookingTable = bookingTable;
    }

    public void addBooking(Booking booking, User master, User client) {
        List<User> users = new ArrayList<>();
        users.add(master);
        users.add(client);
        bookingTable.put(booking, users);
    }

    public void getBooking(int scheduleId) {
    }

    public void printValues() {
        for(Map.Entry<Booking, List<User>> entry : bookingTable.entrySet()){
            Booking key = entry.getKey();
            System.out.println("Key: ");
            System.out.println(key);
            List<User> usersList = entry.getValue();
            for (User user : usersList) {
                System.out.println("Values: "+ user);
            }
        }
    }
}
