package ua.salon.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.controller.PagesJSP;
import ua.salon.schedule.services.BookingService;
import ua.salon.schedule.services.service_factory.ServiceFactory;
import ua.salon.schedule.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveBookingCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private BookingService bookingService;
    private UserService userService;

    public BookingApprovalCommand() {
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
        String chosenDate = session.getAttribute("bookDate");
        rootLogger.debug("bookDate:" + chosenDate);
        String chosenTime = session.getParameter("bookingChosenTime");
        rootLogger.debug("bookingChosenTime: " + chosenTime);
        LocalDateTime timeSlotStart;
        return PagesJSP.BOOKING_APPROVED;
    }
}
