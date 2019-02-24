package ua.salon.schedule.command;

import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.dao.user.UserDAO;
import ua.salon.schedule.model.user.User;
import ua.salon.schedule.model.user.UserRole;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMasterCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
