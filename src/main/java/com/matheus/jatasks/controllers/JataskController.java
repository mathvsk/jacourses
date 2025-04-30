package com.matheus.jatasks.controllers;

import com.matheus.jatasks.dtos.CreateTaskDTO;
import com.matheus.jatasks.dtos.GetAllTasksDTO;
import com.matheus.jatasks.dtos.UpdateTaskDTO;
import com.matheus.jatasks.exceptions.NotFounException;
import com.matheus.jatasks.useCases.CreateTaskUseCase;
import com.matheus.jatasks.useCases.GetAllTasksUseCase;
import com.matheus.jatasks.useCases.UpdateTaskUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jatask")
public class JataskController {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @Autowired
    private GetAllTasksUseCase getAllTasksUseCase;

    @Autowired
    private UpdateTaskUseCase updateTaskUseCase;

    @GetMapping("/courses")
    public ResponseEntity<List<GetAllTasksDTO>> getAll() {
        var result = this.getAllTasksUseCase.execute();

        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/courses")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateTaskDTO createTaskDTO) {
        this.createTaskUseCase.execute(createTaskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @Valid @RequestBody UpdateTaskDTO updateTaskDTO) {
        try {
            this.updateTaskUseCase.execute(id, updateTaskDTO);

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NotFounException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
