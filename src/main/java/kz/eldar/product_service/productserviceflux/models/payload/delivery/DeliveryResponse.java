package kz.eldar.product_service.productserviceflux.models.payload.delivery;

public record DeliveryResponse(
        Long id,
        Long productId,
        String address
) {}
