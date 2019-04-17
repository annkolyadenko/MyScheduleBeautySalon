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
        String masterName = (String)request.getAttribute("masterName");
        rootLogger.debug("masterName" + masterName);
        String chosenDate = (String)request.getAttribute("chosenDate");
        rootLogger.debug("chosenDate" + chosenDate);
        String chosenTime = (String)request.getAttribute("chosenTime");
        rootLogger.debug("chosenTime" + chosenTime);
        /*String chosenDate = request.get*/
        return PagesJSP.BOOKING_PAGE;
    }
}

