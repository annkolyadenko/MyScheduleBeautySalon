package ua.salon.schedule.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.dao.user.UserDAO;
import ua.salon.schedule.model.user.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;
    private static final Logger rootlogger = LogManager.getRootLogger();

    public UserService() {
        userDAO = new UserDAO();
    }

    public User findUserByLogin(String email) {
        rootlogger.debug("invoking userDAO.findUserByLogin(email) method");
        return userDAO.findUserByLogin(email);
    }

    public List<User> getAllMasters(){
        rootlogger.debug("invoking getAllMasters() method");
        return userDAO.getAllMasters();
    }

    public User findUserById(int id) {
        rootlogger.debug("invoking userDAO.findUserById(id) method");
        return  userDAO.findUserById(id);

    }


}
