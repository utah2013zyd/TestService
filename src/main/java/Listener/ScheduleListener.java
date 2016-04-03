package Listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import Task.FetchDataTask;

public class ScheduleListener implements ServletContextListener{

    private Timer timer;
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        timer.cancel();
    }

    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("start fetching data...");
        timer = new Timer();
        timer.schedule(new FetchDataTask(), 0, 10*1000);
    }
    
}
