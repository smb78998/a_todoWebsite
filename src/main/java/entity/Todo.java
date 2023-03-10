package entity;

import jakarta.persistence.*;

@Entity
@NamedQuery( name = "taskShow" , query = "SELECT e FROM Todo e ")



public class Todo {
    @Basic
    @Column(name = "task")
    private String task;

    //TODO: make sure  we manually increment id within "HelloServlet" , or "AddServlet"
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    //generated value gave issues before
    @Id
    @Column(name = "id")
    private int id;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (id != todo.id) return false;
        if (task != null ? !task.equals(todo.task) : todo.task != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = task != null ? task.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return
                " ID: " + id  + "\t"+ "Task: " + task +"\n";
    }
}
