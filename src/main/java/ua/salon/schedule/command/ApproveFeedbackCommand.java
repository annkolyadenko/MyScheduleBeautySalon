package ua.salon.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.command.jsp_pages.PagesJSP;
import ua.salon.schedule.model.booking.Booking;
import ua.salon.schedule.model.review.Review;
import ua.salon.schedule.services.BookingService;
import ua.salon.schedule.services.ReviewService;
import ua.salon.schedule.services.service_factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveFeedbackCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private ReviewService reviewService;
    private BookingService bookingService;

    public ApproveFeedbackCommand() {
        bookingService = ServiceFactory.getBookingService();
        reviewService = ServiceFactory.getReviewService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        rootLogger.debug("ApproveFeedbackCommand class started execute() ApproveFeedbackCommand method");
        String bookingId = request.getParameter("bookingId");
        rootLogger.debug("bookingId: " + bookingId);
        String review = request.getParameter("review");
        rootLogger.debug("review: " + review);

        Review rw = new Review();
        Booking booking = bookingService.getBookingById(Integer.valueOf(bookingId));
        rw.setText(review);
        rw.setBooking(booking);
        rootLogger.debug("Review: "+rw);
        reviewService.addReview(rw);
        return PagesJSP.FEEDBACK_APPROVED;
    }
}
