package com.example.servlets_v001;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DelServlet", value = "/DelServlet/*")
public class DelServlet extends HttpServlet {
    private String message;


    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("The GET request has been made to /hello");

        //what response
        response.setContentType("text/html");
        response.getWriter().println("<h1>Post Request to DelServlet </h1>");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("The POST request has been made to /delServlet");
        String task = request.getParameter("task");


        response.setContentType("text/html");

        response.getWriter().println(
                " <head>"+
                        "<link href=\"style01.css\" rel=\"stylesheet\" type=\"text/css\">"+
                        "/<head>" +


                        "<body>"+
                        "<h1>Todo Delete</h1>"+
                        "<p> \"" + task + "\" was deleted</p>"+
                        "</body>"+

                        "<form name = \"myForm\" action = \"index.jsp\" method = \"post\">\n" +
                        "           <input type = \"submit\" value=\"Back To Main Page\" name = \"Submit\"/>\n" +
                        " </form>\n"


        );




    }

    public void destroy() {
    }
}