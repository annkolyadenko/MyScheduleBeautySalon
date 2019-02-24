package ua.salon.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.controller.PagesJSP;
import ua.salon.schedule.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Logs out registred user from MyScheduleBeautySalon system and invalidate session
 */
public class LogoutCommand implements ActionCommand {

    private static final Logger rootLogger = LogManager.getRootLogger();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        rootLogger.debug("LogoutCommand class started execute() method");
        HttpSession session = request.getSession();
        session.invalidate();
        rootLogger.debug("Redirecting to PagesJSP.MAIN_PAGE");
        return PagesJSP.LOG_OUT_PAGE;
    }
}
