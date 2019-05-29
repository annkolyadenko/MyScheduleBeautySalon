package ua.salon.schedule.controller.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.factory.ActionCommand;
import ua.salon.schedule.command.factory.ActionFactory;
import ua.salon.schedule.singleton_executor.ScheduledExecutor;
import ua.salon.schedule.ssl_email_sender.MailClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Main controller (@WebServlet) that dispatches request to appropriate command
 * */

@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static final Logger rootlogger = LogManager.getRootLogger();

    @Override
    public void init() {
        ScheduledExecutor.INSTANCE.threadInvoke();
        MailClient.getInstance();
        rootlogger.info("Servlet successfully initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        handler(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        handler(request,response);
    }

    private void handler(HttpServletRequest request, HttpServletResponse response) {
        try {
            ActionFactory client = new ActionFactory();
            ActionCommand command = client.defineCommand(request);
            String page = command.execute(request,response);
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            rootlogger.error(e.getMessage(), e);
        } catch (IOException e) {
            rootlogger.error(e.getMessage(), e);
        }
    }

    @Override
    public void destroy() {
        ScheduledExecutor.INSTANCE.threadShutdown();
        rootlogger.info("Servlet successfully destroyed");
    }
}
