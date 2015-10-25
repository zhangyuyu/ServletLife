package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ReportListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("*************Context created on*************");
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("*************Context destroy*************");
    }
}