package ua.salon.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.command.jsp_pages.PagesJSP;
import ua.salon.schedule.services.BookingService;
import ua.salon.schedule.services.service_factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackProposalCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private BookingService userService;

    public FeedbackProposalCommand() {
        userService = ServiceFactory.getBookingService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        rootLogger.debug("FeedbackProposalCommand class started execute() FeedbackProposalCommand method");
        String bookingId = request.getParameter("bookingId");
        rootLogger.debug("bookingId: " + bookingId);
        String bookingDate = request.getParameter("bookingDate");
        rootLogger.debug("bookingDate: " + bookingDate);
        request.setAttribute("bookingDate", bookingDate);
        String bookingTime = request.getParameter("bookingTime");
        rootLogger.debug("bookingTime: " + bookingTime);
        request.setAttribute("bookingTime", bookingTime);
        String masterName = request.getParameter("masterName");
        rootLogger.debug("masterName: " + masterName);
        request.setAttribute("masterName", masterName);
        String userName = request.getParameter("userName");
        rootLogger.debug("userName: " + userName);
        request.setAttribute("userName", userName);
        return PagesJSP.FEEDBACK_PAGE;
    }
}
