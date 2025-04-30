package com.matheus.jatasks.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTaskDTO {
    @NotNull
    private String name;

    @NotNull
    private String category;
}
