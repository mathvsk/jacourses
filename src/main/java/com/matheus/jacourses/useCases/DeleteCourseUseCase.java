package com.matheus.jacourses.useCases;

import com.matheus.jacourses.exceptions.NotFoundException;
import com.matheus.jacourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(String id) throws NotFoundException {
        var task = this.courseRepository.findById(UUID.fromString(id)).orElseThrow(() -> new NotFoundException("Task not found"));

        this.courseRepository.delete(task);
    }
}
