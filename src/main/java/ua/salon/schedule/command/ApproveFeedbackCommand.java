package ua.salon.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.command.jsp_pages.PagesJSP;
import ua.salon.schedule.services.ReviewService;
import ua.salon.schedule.services.service_factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveFeedbackCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private ReviewService reviewService;

    public ApproveFeedbackCommand() {
        reviewService = ServiceFactory.getReviewService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        rootLogger.debug("ApproveFeedbackCommand class started execute() ApproveFeedbackCommand method");
        String bookingId = request.getParameter("bookingId");
        rootLogger.debug("bookingId: " + bookingId);
        return PagesJSP.FEEDBACK_APPROVED;
    }
}
