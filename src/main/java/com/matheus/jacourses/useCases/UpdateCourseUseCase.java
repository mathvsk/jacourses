package com.matheus.jacourses.useCases;

import com.matheus.jacourses.dtos.UpdateCourseDTO;
import com.matheus.jacourses.exceptions.NotFoundException;
import com.matheus.jacourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(String id, UpdateCourseDTO updateCourseDTO) throws NotFoundException {
        var task = courseRepository.findById(UUID.fromString(id)).orElseThrow(() -> new NotFoundException("Task not found"));
        task.setName(updateCourseDTO.getName());
        task.setCategory(updateCourseDTO.getCategory());

        courseRepository.save(task);
    }
}
