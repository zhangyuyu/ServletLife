package servlet;

import javax.servlet.*;
import java.io.IOException;

public class ErrorServlet implements Servlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("***********This is the error servlet init***********");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("***********This is the error servlet service***********");
        throw new ServletException("This is the ServletException");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("***********This is the error servlet destroy***********");
    }

}
