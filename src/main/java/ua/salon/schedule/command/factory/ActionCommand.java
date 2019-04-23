package main.schedule.command.factory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ActionCommand interface
 */
public interface ActionCommand {
    String execute(HttpServletRequest request, HttpServletResponse response);
}
