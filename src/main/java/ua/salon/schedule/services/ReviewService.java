package ua.salon.schedule.services;

import ua.salon.schedule.dao.review.ReviewDAO;
import ua.salon.schedule.model.review.Review;

import java.util.List;

public class ReviewService {
   private ReviewDAO reviewDAO;

    public ReviewService() {
        reviewDAO = new ReviewDAO();
    }

    public void addReview(Review review) {
        reviewDAO.addReview(review);
    }

    public List<Review> getReviewsByMasterId(int masterId) {
        return reviewDAO.getReviewsByMasterId(masterId);
    }

    public List<Review> getReviewByBookingId(int bookingId) {
        return reviewDAO.getReviewByBookingId(bookingId);
    }
}
