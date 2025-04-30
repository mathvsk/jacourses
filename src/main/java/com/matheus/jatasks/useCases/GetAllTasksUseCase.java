package com.matheus.jatasks.useCases;

import com.matheus.jatasks.dtos.GetAllTasksDTO;
import com.matheus.jatasks.models.TaskModel;
import com.matheus.jatasks.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTasksUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public List<GetAllTasksDTO> execute() {
        var tasks = taskRepository.findAll();

        return tasks.stream()
                .map(task -> GetAllTasksDTO.builder()
                        .id(task.getId())
                        .name(task.getName())
                        .category(task.getCategory())
                        .active(task.isActive())
                        .build())
                .toList();
    }
}
