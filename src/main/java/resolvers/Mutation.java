package resolvers;

import model.Project;
import model.Task;
import model.User;
import repository.ProjectRepository;
import repository.TaskRepository;
import repository.UserRepository;

public class Mutation extends GraphQLResolverCustom {

    public Mutation(TaskRepository taskRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        super(taskRepository, projectRepository, userRepository);
    }

    public Project createProject(String name, String inChargeOf) {
        return projectRepository.save(new Project(name, inChargeOf));
    }

    public Task createTask(String projectId, String description) {
        return taskRepository.save(new Task(projectId, description));
    }

    public User createUser(String name, int age) {
        return userRepository.save(new User(name, age));
    }


    public Project updateProject(String id, String name, String inChargeOf) {
        return projectRepository.update((Project) new Project(name, inChargeOf).setId(id));
    }

    public Task updateTask(String id, String description) {
        return taskRepository.update((Task) new Task().setDescription(description).setId(id));
    }

    public User updateUser(String id, String name, int age) {
        return userRepository.update((User) new User(name, age).setId(id));
    }


    public Project deleteProject(String id) {
        return projectRepository.delete(id);
    }

    public Task deleteTask(String id) {
        return taskRepository.delete(id);
    }

    public User deleteUser(String id) {
        return userRepository.delete(id);
    }
}
