package ua.salon.schedule.controller.servlet;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
/**To do: class for extracting request attributes and values.
 * In accordance with the possible threat of modifying a request it is better to work with request processing manager object*/
public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;
    //конструкторы
    //метод извлечния информации из запроса
    public void extractValues(HttpServletRequest request) {
        //реализацияж
    }

    //метод добавления в запрос данніх для передачи в jsp
    public void insertAttributes(HttpServletRequest request) {

    }
    //some methods;
}
