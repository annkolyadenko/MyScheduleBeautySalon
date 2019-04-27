package ua.salon.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.controller.PagesJSP;
import ua.salon.schedule.model.user.User;
import ua.salon.schedule.model.user.UserRole;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReturnToHomePageCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        rootLogger.debug("ReturnToHomePageCommand class started execute() method");
        System.out.println("inside return method1");
        User user = (User) request.getSession().getAttribute("authorizedUser");
        UserRole authorizedUserRole = user.getRole();
        rootLogger.debug("User role" + authorizedUserRole);
        if (authorizedUserRole != null) {
            if (authorizedUserRole.equals(UserRole.ADMINISTRATOR)) {
                return PagesJSP.ADMIN_PAGE;
            }
            if (authorizedUserRole.equals(UserRole.MASTER)) {
                return PagesJSP.MASTER_PAGE;
            }
            if (authorizedUserRole.equals(UserRole.CLIENT)) {
                return PagesJSP.CLIENT_PAGE;
            }
        }
        return PagesJSP.MAIN_PAGE;
    }
}

