package ua.salon.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.controller.PagesJSP;
import ua.salon.schedule.model.booking.Booking;
import ua.salon.schedule.model.user.User;
import ua.salon.schedule.model.user.UserRole;
import ua.salon.schedule.services.BookingService;
import ua.salon.schedule.services.service_factory.ServiceFactory;
import ua.salon.schedule.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class DisplayBookingsByMasterAndDateCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private BookingService bookingService;
    private UserService userService;

    public DisplayBookingsByMasterAndDateCommand() {
        bookingService = ServiceFactory.getBookingService();
        userService = ServiceFactory.getUserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        rootLogger.debug("DisplayBookingsByMasterAndDateCommand class started execute() method");
        User authorizedUser = (User) session.getAttribute("authorizedUser");
        int userId = authorizedUser.getId();
        rootLogger.debug("userId: " + userId);
        int masterId;
        if(authorizedUser.getRole().equals(UserRole.MASTER)){
            masterId = userId;
        }else {
            masterId = Integer.parseInt(request.getParameter("masterId"));
        }
        rootLogger.debug("masterId: "+ masterId);
        String date = request.getParameter("chosenDate");
        rootLogger.debug("chosenDate: " + date);
        User master = userService.findUserById(masterId);
        rootLogger.debug("master: " + master);
        String masterName = master.getName();
        int masterPhone = master.getPhone();
        List<Booking> bookingList = bookingService.getAllBookingsByMasterIdAndDate(masterId, date);
        rootLogger.debug(bookingList);
        request.setAttribute("date", date);
        request.setAttribute("masterName", masterName);
        request.setAttribute("masterPhone", masterPhone);
        request.setAttribute("bookings", getScheduleFormedBookingList(bookingList));
        rootLogger.debug("Size of booking list: " + bookingList.size());
        rootLogger.debug("redirecting from DisplayBookingsByMasterAndDateCommand.class to PagesJSP.BOOKING_TABLE");
        return PagesJSP.BOOKING_LIST;
    }

    private ArrayList<Booking> getScheduleFormedBookingList(List<Booking> bookingList) {
        ArrayList<Booking> bookings = new ArrayList<>(9);
        for (int i = 0, j = 0; i < 9; i++) {
            System.out.println(i);
            if (j != bookingList.size() && bookingList.get(j).getTime().equals((i + 8))) {
                System.out.println("getTime: " + bookingList.get(j).getTime());
                bookings.add(bookingList.get(j++));
                System.out.println("Added "+j);
            } else bookings.add(null);
        }
        return bookings;
    }
}
