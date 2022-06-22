package ru.t1.dkononov.tm.service;

import ru.t1.dkononov.tm.api.IProjectRepository;
import ru.t1.dkononov.tm.api.IProjectService;
import ru.t1.dkononov.tm.model.Project;
import ru.t1.dkononov.tm.repository.ProjectRepository;

import java.util.List;

public class ProjectService implements IProjectService {

    private IProjectRepository projectRepository;

    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project create(String name, String description) {
        if(name == null) return null;
        if(description == null) return null;
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        add(project);
        return project;
    }

    @Override
    public Project add(final Project project) {
        if(project == null) return null;
        return projectRepository.add(project);
    }

    @Override
    public void clear() {
        projectRepository.clear();
    }

}
