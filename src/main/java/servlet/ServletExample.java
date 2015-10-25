package servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletExample implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("***********This is the servlet init***********");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        PrintWriter print = response.getWriter();
        print.println("hello world");
        System.out.println("***********This is the servlet service***********");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("***********This is the servlet destroy***********");
    }
}