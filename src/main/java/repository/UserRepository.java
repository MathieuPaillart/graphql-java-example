package repository;

import model.Project;
import model.Task;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository extends Repository<User> {

    public UserRepository() {
        //add some links to start off with
        list.add((User) new User("Mathieu", 18).setId("0"));
        list.add((User) new User("Laurent", 19).setId("1"));
    }
}