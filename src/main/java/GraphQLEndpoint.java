import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.ProjectRepository;
import repository.TaskRepository;
import repository.UserRepository;
import resolvers.Mutation;
import resolvers.Query;

import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        TaskRepository taskRepository = new TaskRepository();
        UserRepository userRepository = new UserRepository();
        ProjectRepository projectRepository = new ProjectRepository();
        return SchemaParser.newParser()
                .file("orchestra.graphqls")
                .resolvers(new Query(taskRepository,projectRepository,userRepository),new Mutation(taskRepository,projectRepository,userRepository))
                .build()
                .makeExecutableSchema();
    }
}