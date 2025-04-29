package com.matheus.jatasks.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String category;
    private boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Nullable
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
