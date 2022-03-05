package com.mustafa.implementations;

import com.mustafa.dto.ProjectDTO;
import com.mustafa.enums.Status;
import com.mustafa.services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {
    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public ProjectDTO save(ProjectDTO object) {
        return super.save(object.getProjectCode(),object);
    }

    @Override
    public void update(ProjectDTO object) {

        ProjectDTO newProject = findByID(object.getProjectCode());
        if (object.getProjectStatus() == null){
            object.setProjectStatus(newProject.getProjectStatus());
        }
        super.update(object.getProjectCode(),object);
    }

    @Override
    public void deleteByID(String id) {
        super.deleteByID(id);
    }

    @Override
    public void delete(ProjectDTO object) {
        super.delete(object);
    }

    @Override
    public ProjectDTO findByID(String id) {
        return super.findByID(id);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETED);
        super.save(project.getProjectCode(),project);
    }
}
