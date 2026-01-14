package kz.eldar.kaspihomework.kaspihomework.models.payload.error;

import java.time.Instant;

public record ApiError(
        String code,
        String message,
        String service,
        Instant timestamp
) {}
