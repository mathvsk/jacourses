package com.matheus.jacourses.controllers;

import com.matheus.jacourses.dtos.CreateCourseDTO;
import com.matheus.jacourses.dtos.GetAllCourseDTO;
import com.matheus.jacourses.dtos.UpdateCourseDTO;
import com.matheus.jacourses.exceptions.NotFoundException;
import com.matheus.jacourses.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private GetAllCoursesUseCase getAllCoursesUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private UpdateActiveCourseUseCase updateActiveCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @GetMapping()
    public ResponseEntity<List<GetAllCourseDTO>> getAll() {
        var result = this.getAllCoursesUseCase.execute();

        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseDTO createCourseDTO) {
        this.createCourseUseCase.execute(createCourseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @Valid @RequestBody UpdateCourseDTO updateCourseDTO) {
        try {
            this.updateCourseUseCase.execute(id, updateCourseDTO);

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> updateActive(@PathVariable String id) {
        try {
            this.updateActiveCourseUseCase.execute(id);

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        try {
            this.deleteCourseUseCase.execute(id);

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
