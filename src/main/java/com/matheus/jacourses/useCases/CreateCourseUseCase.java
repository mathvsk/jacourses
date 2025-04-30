package com.matheus.jacourses.useCases;

import com.matheus.jacourses.dtos.CreateCourseDTO;
import com.matheus.jacourses.models.CourseModel;
import com.matheus.jacourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(CreateCourseDTO createCourseDTO) {
        var taskModel = CourseModel.builder()
                .name(createCourseDTO.getName())
                .category(createCourseDTO.getCategory())
                .active(createCourseDTO.isActive())
                .build();

        this.courseRepository.save(taskModel);
    }
}
