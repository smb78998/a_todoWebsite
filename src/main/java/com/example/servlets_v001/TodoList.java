package com.example.servlets_v001;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> todoListArray= new ArrayList<String>();;
    private String title;
    private String action;



    //constructor
    TodoList(){

    }
    //add a String value to todoListArray, which displays whole to do list
    void addTodo(String action) {

        this.action = action;
        todoListArray.add(this.action);

    }

    //deletes one to do from todoListArray, user selects which value is deleted by an int
    void delTodo(int numToDel) {

        //TEST IF INDEX ESXIST, between 0 and array list size , then delete
        if( 0 < numToDel && numToDel <=todoListArray.size()) {
            todoListArray.remove(numToDel -1);
        }else {
            System.out.println("Invalid Input");
        }
    }

    //clears the whole todoListArray
    //TODO: add to menu in main class
    void clear() {
        todoListArray.clear();
    }

    public String toString() {
        String temp = null;
        String list = "<"+ this.title+ ">\n";

        for(int i = 0; i < todoListArray.size() ; i++) {

            int j = i+1;

            todoListArray.get(i);
            temp = list.concat("\t"+ j + "-" + todoListArray.get(i) + "\n");
            list = temp;
        }


        return temp;

    }


}
