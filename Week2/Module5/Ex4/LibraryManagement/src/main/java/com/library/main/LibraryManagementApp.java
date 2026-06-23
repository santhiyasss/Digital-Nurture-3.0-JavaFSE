package com.library.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Starting Library Management Application ===");

        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== Spring Context Loaded Successfully ===");
        System.out.println("Spring Version: " +
            org.springframework.core.SpringVersion.getVersion());
        System.out.println("Maven Project configured with:");
        System.out.println("  - Spring Context dependency");
        System.out.println("  - Spring AOP dependency");
        System.out.println("  - Spring WebMVC dependency");
        System.out.println("  - Maven Compiler Plugin (Java 1.8)");
        System.out.println("=== Maven Project Setup Completed Successfully ===");

        ((ClassPathXmlApplicationContext) context).close();
    }
}