package ua.salon.schedule.dao.booking;

import org.apache.logging.log4j.*;
import ua.salon.schedule.connection_utils.DatasourceJNDI;
import ua.salon.schedule.dao.TimeConverter;
import ua.salon.schedule.dao.user.UserDAO;
import ua.salon.schedule.model.booking.Booking;
import ua.salon.schedule.model.user.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    private Connection connection;

    private static final Logger rootLogger = LogManager.getRootLogger();

    private static final String ADD_BOOKING = "INSERT INTO booking (booking_master_id, booking_client_id, schedule_slot_start, schedule_slot_end) VALUES (?,?,?,?)";
    private static final String FIND_BOOKING_BY_MASTER_ID = "SELECT * FROM booking WHERE booking_master_id = ?";
    /*This is the fastest-performing, lowest-memory, least-resource intensive method*/
    private static final String FIND_BOOKING_BY_MASTER_ID_AND_DATE = "SELECT * FROM booking WHERE booking_master_id = ? AND DATE(schedule_slot_start) = ? ";
    private static final String FIND_BOOKING_BY_ID = "SELECT * FROM booking WHERE booking_id = ?";

    public BookingDAO() {
    }

    public void addBooking(Booking booking) {
        PreparedStatement ps = null;
        try {
            connection = DatasourceJNDI.getConnection();
            ps = connection.prepareStatement(ADD_BOOKING);
            Timestamp mySqlStart = TimeConverter.getConvertedTimeSlotStart(booking);
            Timestamp mySqlEnd = TimeConverter.getConvertedTimeSlotEnd(booking);
            ps.setInt(1, booking.getMaster().getId());
            ps.setInt(2, booking.getClient().getId());
            ps.setTimestamp(3, mySqlStart);
            ps.setTimestamp(4, mySqlEnd);
            ps.executeUpdate();
        } catch (SQLException e) {
            rootLogger.warn("SQLException in adding user to database", e);
        } finally {
           /* try {
              DatasourceJNDI.closeConnection(connection, ps);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }*/
        }
    }

    public List<Booking> getAllBookingsByMasterID(int masterId) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        UserDAO userDao = new UserDAO();
        /*Booking booking = new Booking();*/
        int bookingId = 0;
        int clientId = 0;
        User master = null;
        User client = null;
        LocalDateTime timeSlotStart = null;
        LocalDateTime timeSlotEnd = null;
        List<Booking> bookingList = new ArrayList<>();
        try {
            connection = DatasourceJNDI.getConnection();
            ps = connection.prepareStatement(FIND_BOOKING_BY_MASTER_ID);
            ps.setInt(1, masterId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                bookingId = rs.getInt("booking_id");
                clientId = rs.getInt("booking_client_id");
                master = userDao.findUserById(masterId);
                client = userDao.findUserById(clientId);
                Timestamp mySqlStart = rs.getTimestamp("schedule_slot_start");
                Timestamp mySqlEnd = rs.getTimestamp("schedule_slot_end");
                timeSlotStart = mySqlStart.toLocalDateTime();
                timeSlotEnd = mySqlEnd.toLocalDateTime();
                booking.setBookingId(bookingId);
                booking.setMaster(master);
                booking.setClient(client);
                booking.setTimeSlotStart(timeSlotStart);
                booking.setTimeSlotEnd(timeSlotEnd);
                bookingList.add(booking);
            }
        } catch (SQLException e) {
            rootLogger.warn("SQLException at getBookingsByMasterID()", e);
        } finally {
            /*try {
                DatasourceJNDI.closeConnection(connection, ps, resultSet);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }*/
        }
        return bookingList;
    }

    public List<Booking> getAllBookingsByMasterIdAndDate(int masterId, String date) /*throws ConnectionNotOpenedException*/ {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        UserDAO userDao = new UserDAO();
        int bookingId = 0;
        int clientId = 0;
        User master = null;
        User client = null;
        LocalDateTime timeSlotStart = null;
        LocalDateTime timeSlotEnd = null;
        List<Booking> bookingList = new ArrayList<>();
        try {
            /*connection = ConnectionUtil.getConnection();*/
            connection = DatasourceJNDI.getConnection();
            ps = connection.prepareStatement(FIND_BOOKING_BY_MASTER_ID_AND_DATE);
            ps.setInt(1, masterId);
            ps.setString(2, date);
            ResultSet rs = ps.executeQuery();
            System.out.println("ResultSet executed");
            while (rs.next()) {
                System.out.println("HOHOHO");
                Booking booking = new Booking();
                bookingId = rs.getInt("booking_id");
                System.out.println("bookingID"+bookingId);
                clientId = rs.getInt("booking_client_id");
                System.out.println("clientID"+clientId);
                master = userDao.findUserById(masterId);
                System.out.println("master"+master.toString());
                client = userDao.findUserById(clientId);
                Timestamp mySqlStart = rs.getTimestamp("schedule_slot_start");
                Timestamp mySqlEnd = rs.getTimestamp("schedule_slot_end");
                timeSlotStart = mySqlStart.toLocalDateTime();
                timeSlotEnd = mySqlEnd.toLocalDateTime();
                booking.setBookingId(bookingId);
                booking.setMaster(master);
                booking.setClient(client);
                booking.setTimeSlotStart(timeSlotStart);
                booking.setTimeSlotEnd(timeSlotEnd);
                System.out.println("Booking"+booking);
                bookingList.add(booking);
                /*bookingList.addBooking(booking);*/
            }
        } catch (SQLException e) {
            rootLogger.warn("SQLException at getBookingsByMasterID()", e);
        } finally {
            /*try {
                DatasourceJNDI.closeConnection(connection, ps, resultSet);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }*/
        }
        return bookingList;
    }

    public Booking getBookingById(int bookingId) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        UserDAO userDao = new UserDAO();
        Booking booking = new Booking();
        int masterId = 0;
        int clientId = 0;
        User master = null;
        User client = null;
        LocalDateTime timeSlotStart = null;
        LocalDateTime timeSlotEnd = null;
        try {
            connection = DatasourceJNDI.getConnection();
            ps = connection.prepareStatement(FIND_BOOKING_BY_ID);
            ps.setInt(1, bookingId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                masterId = rs.getInt("booking_master_id");
                clientId = rs.getInt("booking_client_id");
                master = userDao.findUserById(masterId);
                client = userDao.findUserById(clientId);
                Timestamp mySqlStart = rs.getTimestamp("schedule_slot_start");
                Timestamp mySqlEnd = rs.getTimestamp("schedule_slot_end");
                timeSlotStart = mySqlStart.toLocalDateTime();
                timeSlotEnd = mySqlEnd.toLocalDateTime();
                booking.setBookingId(bookingId);
                booking.setMaster(master);
                booking.setClient(client);
                booking.setTimeSlotStart(timeSlotStart);
                booking.setTimeSlotEnd(timeSlotEnd);
            }
        } catch (SQLException e) {
            rootLogger.warn("SQLException at getBookingsByMasterID()", e);
        } finally {
            /*try {
              DatasourceJNDI.closeConnection(connection, ps, resultSet);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }*/
        }
        return booking;
    }
}

