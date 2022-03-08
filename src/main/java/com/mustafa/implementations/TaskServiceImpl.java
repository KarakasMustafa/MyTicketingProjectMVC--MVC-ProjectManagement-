package com.mustafa.implementations;

import com.mustafa.dto.TaskDTO;
import com.mustafa.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {
    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public TaskDTO save(TaskDTO object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void update(TaskDTO object) {

        TaskDTO foundProject = findByID(object.getId());
        object.setAssignedDate(foundProject.getAssignedDate());
        object.setTaskStatus(foundProject.getTaskStatus());
        super.update(object.getId(),object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public void delete(TaskDTO object) {
        super.delete(object);
    }

    @Override
    public TaskDTO findByID(Long id) {
        return super.findByID(id);
    }

}
