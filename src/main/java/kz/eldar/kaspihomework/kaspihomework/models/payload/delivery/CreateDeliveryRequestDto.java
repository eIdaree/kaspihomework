package kz.eldar.kaspihomework.kaspihomework.models.payload.delivery;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateDeliveryRequestDto(
        @NotNull(message = "Product ID is required")
        Long productId,

        @NotEmpty(message = "Delivery address is required")
        String address
) { }
