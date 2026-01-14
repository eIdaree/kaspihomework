package kz.eldar.kaspihomework.kaspihomework.models.payload.product;

import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

public record ProductResponseDto(
        Long id,
        String name,
        BigDecimal price
) {}
