package ua.salon.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.controller.PagesJSP;
import ua.salon.schedule.model.booking.Booking;
import ua.salon.schedule.services.BookingService;
import ua.salon.schedule.services.service_factory.ServiceFactory;
import ua.salon.schedule.services.UserService;

import ua.salon.schedule.model.user.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApproveBookingCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private BookingService bookingService;
    private UserService userService;

    public ApproveBookingCommand() {
        bookingService = ServiceFactory.getBookingService();
        userService = ServiceFactory.getUserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Booking booking = new Booking();
        rootLogger.debug("ApproveBookingCommand class started execute() method");
        HttpSession session = request.getSession(false);
        User authorizedUser = (User)session.getAttribute("authorizedUser");
        rootLogger.debug("authorizedUser: "+ authorizedUser);
        User master = (User)session.getAttribute("chosenMaster");
        rootLogger.debug("chosenMaster: " + master);
        String chosenDate = (String)session.getAttribute("bookDate");
        rootLogger.debug("bookDate:" + chosenDate);
        String chosenTime = (String)session.getAttribute("bookTime");
        rootLogger.debug("bookingChosenTime: " + chosenTime);
        LocalDateTime timeSlotStart;
        return PagesJSP.BOOKING_APPROVED;
    }
}
