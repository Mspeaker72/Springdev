package com.luhlatsdev;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luhlatsdev.Users.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


/**
 * Apache Tomcat is an open-source web server and servlet container developed by the Apache Software Foundation.
 * It implements the Java Servlet, JavaServer Pages (JSP), WebSocket, and Java Expression Language (EL) technologies.
 * Tomcat provides a runtime environment for Java web applications, allowing them to be deployed and run efficiently.
 * It supports the execution of Java Servlets and JSP pages, handling HTTP requests and responses, and managing session
 * persistence. Tomcat is often used as an embedded server in Java web applications, offering scalability, reliability,
 * and performance for hosting web applications.
 */

// jetty ??

@RestController
// Annotation to declare this class as a Spring Boot application
@SpringBootApplication
//@AutoConfiguration
//@ComponentScan(basePackages = "com.luhlatsdev")
public class Main {

    private final HashMap<String,Person> users = new HashMap<>();

    private final ObjectMapper objectMapper = new ObjectMapper();



    // Handler method for GET requests with path variable 'name'
//    @GetMapping("/{name}")
//    public String greeting(@PathVariable String name){
//        // Returns a greeting message with the provided name
//
//       try {
//           for(String person : users){
//               if(person.equals(name)){
//                   return "{\"message\":\""+"Welcome back "+name+"\"}";
//               }
//           }
//       }catch (NullPointerException e){
//           String error = "User not found please " +
//                   "use join/name to join the program";
//           return "{\"message\":\""+ error +"\"}";
//       }
//
//        return "{\"message\":\""+"user with name "+name+" not found"+"\"}";
//    }

    @PostMapping("/join")
    public String verifyUser(@RequestBody String body){


        try {
            JsonNode request =objectMapper.readTree(body);
            String name = request.get("name").asText();
            String password = request.get("password").asText();
            String email = request.get("email").asText();
            System.out.println(email);

            Person newUser = new Person(name,password,email);
            users.put(email,newUser);


        }catch (Exception e){
            System.out.println(e.getMessage());
            return "{\"message\":\""+"error"+"\"}";
        }


        return "{\"message\":\""+"success"+"\"}";
    }

    @GetMapping("profile/{email}")
    public String viewProfile(@PathVariable String email){

       Person query_user = users.get(email);


        return "{\"name\":\""+query_user.getName()+"\"," +
                "\"email\":\""+query_user.getEmail()+"\"}";


    }

    // Entry point of the application
    public static void main(String[] args) {
        // Bootstrap the Spring application and start the embedded Tomcat server
        SpringApplication.run(Main.class, args);
    }
}
