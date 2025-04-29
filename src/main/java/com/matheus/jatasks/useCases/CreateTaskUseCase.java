package com.matheus.jatasks.useCases;

import com.matheus.jatasks.dtos.CreateTaskDTO;
import com.matheus.jatasks.models.TaskModel;
import com.matheus.jatasks.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(CreateTaskDTO createTaskDTO) {
        var taskModel = TaskModel.builder()
                .name(createTaskDTO.getName())
                .category(createTaskDTO.getCategory())
                .active(createTaskDTO.isActive())
                .build();

        this.taskRepository.save(taskModel);
    }
}
