package com.matheus.jatasks.useCases;

import com.matheus.jatasks.dtos.UpdateTaskDTO;
import com.matheus.jatasks.exceptions.NotFoundException;
import com.matheus.jatasks.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(String id, UpdateTaskDTO updateTaskDTO) throws NotFoundException {
        var task = taskRepository.findById(UUID.fromString(id)).orElseThrow(() -> new NotFoundException("Task not found"));
        task.setName(updateTaskDTO.getName());
        task.setCategory(updateTaskDTO.getCategory());

        taskRepository.save(task);
    }
}
