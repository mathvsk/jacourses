package com.matheus.jatasks.useCases;

import com.matheus.jatasks.exceptions.NotFounException;
import com.matheus.jatasks.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateActiveTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(String id) throws NotFounException {
        var task = this.taskRepository.findById(UUID.fromString(id)).orElseThrow(() -> new NotFounException("Task not found"));
        task.setActive(!task.isActive());
        this.taskRepository.save(task);
    }
}
