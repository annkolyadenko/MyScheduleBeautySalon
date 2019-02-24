package ua.salon.schedule.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.controller.PagesJSP;
import ua.salon.schedule.model.user.User;
import ua.salon.schedule.services.service_factory.ServiceFactory;
import ua.salon.schedule.services.UserService;

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
        /*request.setAttribute("mastersList", mastersList);*/
        rootLogger.debug("Size of booking list: " + mastersList.size());
        return PagesJSP.MASTER_LIST;
    }

}
