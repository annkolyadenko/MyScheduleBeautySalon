package ua.salon.schedule.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;
/**
 * This filter ensures that if the browser has not set the encoding used in the request, it has set UTF-8.
 * The other thing that this filter does is set the default encoding of the response,
 * i.e. the encoding in which the html is returned / whatever.
 */

public class CharsetFilter implements Filter {
    private String encoding;
    private static final Logger rootLogger = LogManager.getRootLogger();

    @Override
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");
        rootLogger.debug(encoding+"Coding!!!");
        if (encoding == null) {
            encoding = "UTF-8";
        }
        rootLogger.debug("CharsetFilter successfully initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }
        // Set the default response content type and encoding
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        next.doFilter(request, response);
    }

    @Override
    public void destroy() {
        rootLogger.debug("CharsetFilter successfully destroyed");
    }
}
