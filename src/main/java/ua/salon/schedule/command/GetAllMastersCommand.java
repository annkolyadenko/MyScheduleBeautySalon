package main.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import main.schedule.command.factory.ActionCommand;
import main.schedule.controller.PagesJSP;
import main.schedule.model.user.User;
import main.schedule.services.service_factory.ServiceFactory;
import main.schedule.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**Gets all masters list from DB through app service layer for displaying in PagesJSP.MASTER_LIST*/
public class GetAllMastersCommand implements ActionCommand {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private UserService userService;

    public GetAllMastersCommand() {
        userService = ServiceFactory.getUserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        rootLogger.debug("LoginCommand class started execute() GetAllMastersCommand method");
        HttpSession session = request.getSession(false);
        List<User> mastersList = userService.getAllMasters();
        rootLogger.debug(mastersList);
        session.setAttribute("mastersList", mastersList);
        rootLogger.debug("Size of booking list: " + mastersList.size());
        return PagesJSP.BOOKING_LIST;
    }

}
