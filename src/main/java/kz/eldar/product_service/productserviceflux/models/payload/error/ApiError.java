package kz.eldar.product_service.productserviceflux.models.payload.error;

import java.time.Instant;

public record ApiError(
        String code,
        String message,
        String service,
        Instant timestamp
) {}
