package com.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
// wweb.xml 사용 WEB-INF
public class Listener2 implements ServletContextListener {

    public Listener2() {
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹 애플리케이션을 시작할 때 호출2");
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹 애플리케이션을 종료할 때 호출2");
    	
    	ServletContext context = sce.getServletContext();
    
    }
	
}
