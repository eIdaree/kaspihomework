package kz.eldar.product_service.productserviceflux.exceptions;

import kz.eldar.product_service.productserviceflux.models.payload.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public Mono<ResponseEntity<ApiError>> handleNotFound(NotFoundException ex) {
        return Mono.just(
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiError(
                                "NOT_FOUND",
                                ex.getMessage(),
                                "product-service",
                                Instant.now()
                        ))
        );
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<ApiError>> handleValidation(WebExchangeBindException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");

        return Mono.just(
                ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ApiError(
                                "VALIDATION_ERROR",
                                message,
                                "product-service",
                                Instant.now()
                        ))
        );
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ApiError>> handleAnyException(Exception ex) {
        return Mono.just(
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiError(
                                "INTERNAL_ERROR",
                                "Unexpected error: " + ex.getMessage(),
                                "product-service",
                                Instant.now()
                        ))
        );
    }
}