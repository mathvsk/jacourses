package com.matheus.jatasks.controllers;

import com.matheus.jatasks.dtos.CreateTaskDTO;
import com.matheus.jatasks.dtos.GetAllTasksDTO;
import com.matheus.jatasks.useCases.CreateTaskUseCase;
import com.matheus.jatasks.useCases.GetAllTasksUseCase;
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
}
