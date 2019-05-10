package ua.salon.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.command.jsp_pages.PagesJSP;
import ua.salon.schedule.model.booking.Booking;
import ua.salon.schedule.services.BookingService;
import ua.salon.schedule.services.service_factory.ServiceFactory;

import ua.salon.schedule.model.user.User;
import ua.salon.schedule.useful_utils.Formatter;
import ua.salon.schedule.useful_utils.TimeUtil;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApproveBookingCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private BookingService bookingService;
    /*private UserService userService;*/

    public ApproveBookingCommand() {
        bookingService = ServiceFactory.getBookingService();
        /*userService = ServiceFactory.getUserService();*/
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        rootLogger.debug("ApproveBookingCommand class started execute() method");
        HttpSession session = request.getSession(false);
        User authorizedUser = (User)session.getAttribute("authorizedUser");
        rootLogger.debug("authorizedUser: "+ authorizedUser);
        User master = (User)session.getAttribute("chosenMaster");
        rootLogger.debug("chosenMaster: " + master);
        String chosenDate = (String)session.getAttribute("bookDate");
        rootLogger.debug("bookDate: " + chosenDate);
        String chosenTime = (String)session.getAttribute("bookTime");
        rootLogger.debug("bookTime: " + chosenTime);
        if (chosenTime.length()==4){
            chosenTime = 0 + chosenTime;
        }
        LocalDateTime timeSlotStart = LocalDateTime.parse((chosenDate+" "+chosenTime), Formatter.getFormatter());
        rootLogger.debug("timeSlotStart:" + timeSlotStart);
        LocalDateTime timeSlotEnd = LocalDateTime.parse(chosenDate+" "+TimeUtil.addTimeGap(chosenTime), Formatter.getFormatter());
        rootLogger.debug("timeSlotEnd" + timeSlotEnd);
        Booking booking = new Booking();
        booking.setMaster(master);
        booking.setClient(authorizedUser);
        booking.setTimeSlotStart(timeSlotStart);
        booking.setTimeSlotEnd(timeSlotEnd);
        rootLogger.debug(booking);
        bookingService.addBooking(booking);
        session.removeAttribute("chosenMaster");
        session.removeAttribute("bookDate");
        session.removeAttribute("bookTime");
        session.removeAttribute("mastersList");
        return PagesJSP.BOOKING_APPROVED;
    }
}
