package ua.salon.schedule.command;

import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.dao.review.ReviewDAO;
import ua.salon.schedule.model.review.Review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddReviewCommand implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
