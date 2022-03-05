package com.mustafa.services;

import com.mustafa.dto.ProjectDTO;

public interface ProjectService extends CrudService<ProjectDTO, String>{

    void complete(ProjectDTO project);

}
