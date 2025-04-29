package com.matheus.jatasks.controllers;

import com.matheus.jatasks.dtos.CreateTaskDTO;
import com.matheus.jatasks.services.CreateTaskUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jatask")
public class JataskController {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @PostMapping("/courses")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateTaskDTO createTaskDTO) {
        this.createTaskUseCase.execute(createTaskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
