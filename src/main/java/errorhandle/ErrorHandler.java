package errorhandle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorHandler extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");

        PrintWriter writer = response.getWriter();
        if(throwable != null) writer.println("Exception : " + throwable);
        if(statusCode != null )writer.println("StatusCode : " + statusCode);
        writer.println("ServletName : " + servletName);
        writer.println("RequestUri : " + requestUri);

        writer.println(request.getParameter("firstName"));
        System.out.println("***********handle error***********");
    }
}
