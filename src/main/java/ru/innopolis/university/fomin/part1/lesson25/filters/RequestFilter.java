package ru.innopolis.university.fomin.part1.lesson25.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestFilter implements Filter {

    protected final Logger LOGGER = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("start init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestUriString = ((HttpServletRequest) servletRequest).getRequestURI();
        LOGGER.info("start doFilter() " + requestUriString);

        MultipleServletRequest request1 = new MultipleServletRequest((HttpServletRequest) servletRequest);
        MultipleServletRequest request2 = new MultipleServletRequest(request1);

        //String requestBody = request1.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        //System.out.println("[REQUEST BODY]: " + requestBody);

        if ("/".equals(requestUriString)) {
            //servletResponse.getOutputStream().print("<response>error</response>");
            //return;
        }


        filterChain.doFilter(request2, servletResponse);
    }

    @Override
    public void destroy() {
        LOGGER.info("start destroy()");
    }
}
