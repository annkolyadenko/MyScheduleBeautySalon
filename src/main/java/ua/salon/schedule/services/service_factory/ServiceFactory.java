package main.schedule.services.service_factory;

import main.schedule.services.BookingService;
import main.schedule.services.ReviewService;
import main.schedule.services.UserService;

/**
 * Factory for creating instances of service layer MVC
 * */
public class ServiceFactory {
    static private UserService userService;
    static private BookingService bookingService;
    static private ReviewService reviewService;

    static {
        userService = new UserService();
        bookingService = new BookingService();
        reviewService = new ReviewService();
    }

    public static UserService getUserService() {
        return userService;
    }

    public static BookingService getBookingService() {
        return bookingService;
    }

    public static ReviewService getReviewService() {
        return reviewService;
    }
}
