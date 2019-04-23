package main.schedule.services;

import main.schedule.dao.review.ReviewDAO;
import main.schedule.model.review.Review;

import java.util.List;

public class ReviewService {
   private ReviewDAO reviewDAO;

    public ReviewService() {
        reviewDAO = new ReviewDAO();
    }

    public void addReview(Review review) {
        reviewDAO.addReview(review);
    }

    public List<Review> getReviewsByMasterID(int masterId) {
        return reviewDAO.getReviewsByMasterID(masterId);
    }
}
