package repository;

import model.Project;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository extends Repository<Task>{
    public TaskRepository() {
        //add some links to start off with
        list.add((Task) new Task("LOL", "Your favorite GraphQL page").setId("0"));
        list.add((Task) new Task("MATHIEU", "The official docks").setId("1"));
    }
}