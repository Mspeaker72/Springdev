package com.luhlatsdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Apache Tomcat is an open-source web server and servlet container developed by the Apache Software Foundation.
 * It implements the Java Servlet, JavaServer Pages (JSP), WebSocket, and Java Expression Language (EL) technologies.
 * Tomcat provides a runtime environment for Java web applications, allowing them to be deployed and run efficiently.
 * It supports the execution of Java Servlets and JSP pages, handling HTTP requests and responses, and managing session
 * persistence. Tomcat is often used as an embedded server in Java web applications, offering scalability, reliability,
 * and performance for hosting web applications.
 */

// jetty ??


// Annotation to declare this class as a Spring Boot application
@SpringBootApplication
public class Main {

    // Handler method for GET requests with path variable 'name'
    @GetMapping("/{name}")
    public String greeting(@PathVariable String name){
        // Returns a greeting message with the provided name
        return "Hello " + name;
    }

    // Entry point of the application
    public static void main(String[] args) {
        // Bootstrap the Spring application and start the embedded Tomcat server
        SpringApplication.run(Main.class, args);
    }
}
