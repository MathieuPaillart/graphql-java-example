package resolvers;

import model.Project;
import model.Task;
import model.User;
import repository.ProjectRepository;
import repository.TaskRepository;
import repository.UserRepository;

import java.util.List;


public class Query extends GraphQLResolverCustom {

    public Query(TaskRepository taskRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        super(taskRepository, projectRepository, userRepository);
    }

    public List<Task> tasks(int count) {

        return taskRepository.findAll();
    }

    public Task task(String id) {
        return taskRepository.getById(id);
    }

    public List<Project> projects(int count) {
        return projectRepository.findAll();
    }

    public Project project(String id) {
        return projectRepository.getById(id);
    }

    public List<User> users(int count) {
        return userRepository.findAll();
    }

    public User user(String id) {
        return userRepository.getById(id);
    }

}