package resolvers;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import lombok.Data;
import repository.ProjectRepository;
import repository.TaskRepository;
import repository.UserRepository;

@Data
public class GraphQLResolverCustom implements GraphQLRootResolver {
    TaskRepository taskRepository;
    ProjectRepository projectRepository;
    UserRepository userRepository;

    public GraphQLResolverCustom(TaskRepository taskRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }
}
