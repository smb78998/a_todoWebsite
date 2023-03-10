package com.example.servlets_v001;

import java.io.*;

import entity.Todo;
import jakarta.persistence.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.util.ArrayList;

@WebServlet(name = "ShowServlet", value = "/ShowServlet/*")
public class ShowServlet extends HttpServlet {



    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("The GET request has been made to /ShowServlet");

        response.setContentType("text/html");
        response.getWriter().println("<h1>Post Request to DelServlet </h1>");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("The POST request has been made to /ShowServlet");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        ArrayList<String> showList = new ArrayList<String>();

        try {
            transaction.begin();

           TypedQuery<Todo> task= entityManager.createNamedQuery("taskShow", Todo.class);

            for (Object o : task.getResultList()) {
                showList.add(o.toString());
           }
            System.out.println(showList);
            transaction.commit();

        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }




        response.setContentType("text/html");

        response.getWriter().println(
                " <head>"+
                        "<link href=\"style01.css\" rel=\"stylesheet\" type=\"text/css\">"+
                        "/<head>" +


                        "<body>"+
                            "<h1>Todo Table</h1>"+


                            "  <div class = 'form'>" +

                           "            <table class = 'showTodo'>" +
                            "                <tbody>" +
                            "                <tr>" +
                            "                    <td>ID</td>" +
                            "                    <td>Task</td>" +
                            "                </tr>" +
                            "            </table>" +
                            "    </div>"  );

        for(int j =0 ; j < showList.size() ; j++){
            response.getWriter().println( "<p>" + showList.get(j) + "</p>");

        }


        response.getWriter().println(
                            "<form name = \"myForm\" action = \"index.jsp\" method = \"post\">\n" +
                            "           <input type = \"submit\" value=\"Back To Main Page\" name = \"Submit\"/>\n" +
                            " </form>\n"+
                        "</body>");

    }

    public void destroy() {
    }
}