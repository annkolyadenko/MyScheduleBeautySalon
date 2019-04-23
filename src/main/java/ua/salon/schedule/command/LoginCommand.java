package main.schedule.command;

import org.apache.logging.log4j.*;
import main.schedule.codec.MD5Util;
import main.schedule.controller.PagesJSP;
import main.schedule.command.factory.ActionCommand;
import main.schedule.model.user.User;
import main.schedule.model.user.UserRole;
import main.schedule.services.service_factory.ServiceFactory;
import main.schedule.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * LoginCommand checks if user is registred, validate password, UserRole and redirect user to PagesJSP.MAIN_PAGE.
 * Create HttpSession for saving users data during session
 **/
public class LoginCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private UserService userService;

    public LoginCommand() {
        userService = ServiceFactory.getUserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        rootLogger.debug("LoginCommand class started execute() LoginCommand method");
        String login = request.getParameter("login");
        rootLogger.debug(login);
        String password = request.getParameter("password");
        rootLogger.debug(password);

        User user = userService.findUserByLogin(login);
        rootLogger.debug("userService.findUserByLogin(login):" + user);

        if (user==null) {
            request.setAttribute("isError", true);
            request.setAttribute("ErrorLoginMessage", "User with such login does not exist");
            return PagesJSP.SIGN_IN_PAGE;
        }
        if (!user.getPassword().equals(MD5Util.md5Custom(password))) {
            request.setAttribute("isError", true);
            request.setAttribute("ErrorLoginMessage", "User with such password does not exist");
            return PagesJSP.SIGN_IN_PAGE;
        } else {
            HttpSession session = request.getSession();

            if (user.getRole().equals(UserRole.ADMINISTRATOR)) {
                User administrator = user;
                rootLogger.debug("Checking initialization: " + administrator);
                session.setAttribute("authorizedUser", administrator);
                rootLogger.debug("Checking session Attribute setting status: " + session.getAttribute("authorizedUser"));
                rootLogger.debug("redirecting from LoginCommand.class to PagesJSP.ADMIN_PAGE");
                return PagesJSP.ADMIN_PAGE;
            }
            if (user.getRole().equals(UserRole.MASTER)) {
                User master = user;
                rootLogger.debug("Checking initialization: " + master);
                session.setAttribute("authorizedUser", master);
                rootLogger.debug("redirecting from LoginCommand.class to PagesJSP.MASTER_PAGE");
                return PagesJSP.MASTER_PAGE;
            }
            if (user.getRole().equals(UserRole.CLIENT)) {
                User client = user;
                rootLogger.debug("Checking initialization: " + client);
                session.setAttribute("authorizedUser", client);
                rootLogger.debug("redirecting from LoginCommand.class to PagesJSP.MASTER_PAGE");
                return PagesJSP.CLIENT_PAGE;
            }
        }
        return PagesJSP.MAIN_PAGE;
    }
}
