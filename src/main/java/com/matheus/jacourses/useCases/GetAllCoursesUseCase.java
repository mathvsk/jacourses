package com.matheus.jacourses.useCases;

import com.matheus.jacourses.dtos.GetAllCourseDTO;
import com.matheus.jacourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCoursesUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<GetAllCourseDTO> execute() {
        var tasks = courseRepository.findAll();

        return tasks.stream()
                .map(task -> GetAllCourseDTO.builder()
                        .id(task.getId())
                        .name(task.getName())
                        .category(task.getCategory())
                        .active(task.isActive())
                        .build())
                .toList();
    }
}
