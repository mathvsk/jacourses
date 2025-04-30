package com.matheus.jacourses.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCourseDTO {
    @NotNull
    private String name;

    @NotNull
    private String category;
}
