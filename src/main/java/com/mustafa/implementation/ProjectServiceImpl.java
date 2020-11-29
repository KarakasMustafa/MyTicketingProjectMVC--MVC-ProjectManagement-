package com.mustafa.implementation;

import com.mustafa.dto.ProjectDTO;
import com.mustafa.enums.Status;
import com.mustafa.services.ProjectService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {
    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public ProjectDTO save(ProjectDTO object) {
        return super.save(object.getProjectCode(),object);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void delete(ProjectDTO object) {
        super.delete(object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(ProjectDTO object) {
        super.update(object.getProjectCode(),object);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setStatus(Status.COMPLETED);
        super.save(project.getProjectCode(),project);
    }
}
