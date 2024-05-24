package com.beck.spring_cache.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDto(
        @NotNull @NotBlank
        String name,
        @NotNull @NotBlank
        String description
) {
}
