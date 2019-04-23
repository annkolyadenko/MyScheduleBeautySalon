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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddBookingCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private BookingService bookingService;
    private UserService userService;

    public AddBookingCommand() {
        bookingService = ServiceFactory.getBookingService();
        userService = ServiceFactory.getUserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        rootLogger.debug("AddBookingCommand class started execute() method");
        HttpSession session = request.getSession(false);
        User authorizedUser = (User)session.getAttribute("authorizedUser");
        int userId = authorizedUser.getId();
        rootLogger.debug("userId: " + userId);
        User master = (User)session.getAttribute("chosenMaster");
        rootLogger.debug("chosenMaster: " + master);
        String masterName = master.getName();
        rootLogger.debug("bookMasterName: " + masterName);
        request.setAttribute("bookMasterName", masterName);
        String chosenDate = request.getParameter("bookingChosenDate");
        rootLogger.debug("bookingChosenDate: " + chosenDate);
        session.setAttribute("bookDate", chosenDate);
        String chosenTime = request.getParameter("bookingChosenTime");
        rootLogger.debug("bookingChosenTime: " + chosenTime);
        session.setAttribute("bookTime", chosenTime);
        return PagesJSP.BOOKING_PAGE;
    }
}

