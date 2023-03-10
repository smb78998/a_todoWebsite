package com.example.servlets_v001;

import java.io.*;

import entity.Todo;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.persistence.*;

@WebServlet(name = "HelloServlet", value = "/HelloServlet/*")
public class HelloServlet extends HttpServlet {
    private String message;
    private static int i = 1; //manually increment?
    public static TodoList mainList = new TodoList();

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("The GET request has been made to /hello");

        //what response
        response.setContentType("text/html");
        response.getWriter().println("<h1>Get Request </h1>");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("The POST request has been made to /hello");
        String task = request.getParameter("task");


        response.setContentType("text/html");

        response.getWriter().println(
               " <head>"+
                "<link href=\"style01.css\" rel=\"stylesheet\" type=\"text/css\">"+
                "/<head>" +


                "<body>"+
                       "<h1>Todo Added</h1>"+
                       "<p> \"" + task + "\" was added</p>"+
                "</body>"+

               "<form name = \"myForm\" action = \"index.jsp\" method = \"post\">\n" +
                       "           <input type = \"submit\" value=\"Back To Main Page\" name = \"Submit\"/>\n" +
                       " </form>\n"

                );



        //ADD TO SQL--------------------------------------------------------------------------------------
        mainList.addTodo(task);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();



        try {
            transaction.begin();

            Todo mainListSql = new Todo();

            mainListSql.setId(i);
            mainListSql.setTask(task);
            entityManager.persist(mainListSql); //sends to sql????

            transaction.commit();

        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        i++;

    }

    public void destroy() {
    }
}


