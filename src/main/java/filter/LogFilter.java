package filter;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {
    private String message;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("***********This is the filter init***********");
        message = "*****************do filter*****************";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(message);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("***********This is the filter destroy***********");
    }
}
