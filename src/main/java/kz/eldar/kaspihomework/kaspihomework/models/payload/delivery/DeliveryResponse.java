package kz.eldar.kaspihomework.kaspihomework.models.payload.delivery;

public record DeliveryResponse(
        Long id,
        Long productId,
        String address
) {}
