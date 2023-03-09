package com.example.servlets_v001;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello/*")
public class HelloServlet extends HttpServlet {
    private String message;

    TodoList mainList = new TodoList();

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("The GET request has been made to /hello");


        //what response
        response.setContentType("text/html");

        response.getWriter().println("<h1>Heading</h1>");
        response.getWriter().println("<p>Here is an other line line</p> ");

        mainList.addTodo("Find cat");
        response.getWriter().println(mainList.toString());


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("The POST request has been made to /hello");
    }

    public void destroy() {
    }
}


