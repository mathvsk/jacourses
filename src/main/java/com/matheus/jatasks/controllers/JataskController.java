package com.matheus.jatasks.controllers;

import com.matheus.jatasks.dtos.PostTaskRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jatask")
public class JataskController {
    @PostMapping("/courses")
    public void create(@Valid @RequestBody PostTaskRequestDTO postTaskRequestDTO) {
        System.out.println("Creating task: " + postTaskRequestDTO);
    }
}
