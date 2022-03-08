package com.mustafa.services;

import com.mustafa.dto.TaskDTO;
import com.mustafa.dto.UserDTO;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long>{

    List<TaskDTO> findTaskByManager(UserDTO manager);
}
