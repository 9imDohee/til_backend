package com.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
// @annotion 사용
@WebListener
public class Listener implements ServletContextListener {

    public Listener() {
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹 애플리케이션을 시작할 때 호출");
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹 애플리케이션을 종료할 때 호출");
    }
	
}
