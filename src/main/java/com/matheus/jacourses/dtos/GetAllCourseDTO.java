package com.matheus.jacourses.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCourseDTO {
    private UUID id;
    private String name;
    private String category;
    private boolean active;
}
