package com.matheus.jacourses.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseDTO {

    @NotNull
    private String name;

    @NotNull
    private String category;
    private boolean active;
}
