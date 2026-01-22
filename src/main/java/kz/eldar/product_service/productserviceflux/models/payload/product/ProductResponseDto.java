package kz.eldar.product_service.productserviceflux.models.payload.product;

import java.math.BigDecimal;

public record ProductResponseDto(
        Long id,
        String name,
        BigDecimal price
) {}
