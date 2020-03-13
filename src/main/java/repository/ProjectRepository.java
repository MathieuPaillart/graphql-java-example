package repository;

import model.Project;

public class ProjectRepository extends Repository<Project> {

    public ProjectRepository() {
        //add some links to start off with
        list.add((Project) new Project("LOL", "Your favorite GraphQL page").setId("0"));
        list.add((Project) new Project("MATHIEU", "The official docks").setId("1"));
    }

}