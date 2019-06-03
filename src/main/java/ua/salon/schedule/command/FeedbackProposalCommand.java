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
        rootLogger.debug("FeedbackProposalCommand class started execute() LoginCommand method");
        return PagesJSP.FEEDBACK_PAGE;
    }
}
