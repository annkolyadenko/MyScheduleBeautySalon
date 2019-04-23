package main.schedule.model.booking;

import org.apache.logging.log4j.*;
import main.schedule.model.user.User;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class BookingTable {
    private Map<Booking, User> bookingTable;

    private static final Logger logger = LogManager.getLogger(BookingTable.class);

    public BookingTable() {
        bookingTable = new TreeMap<>(Comparator.comparing(Booking::getTimeSlotStart));
    }

    public void addBooking(Booking booking, User client) {
        bookingTable.put(booking, client);
    }

    public void printValues() {
        for(Map.Entry<Booking, User> entry : bookingTable.entrySet()){
            Booking key = entry.getKey();
            System.out.println(key);
            User client = entry.getValue();
            System.out.println(client);
            }
        }

    public int size(){
        return bookingTable.size();
    }
}
