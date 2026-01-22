package kz.eldar.product_service.productserviceflux.services;

import kz.eldar.product_service.productserviceflux.models.payload.product.CreateProductRequestDto;
import kz.eldar.product_service.productserviceflux.models.payload.product.ProductResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<ProductResponseDto> findById(Long id);
    Flux<ProductResponseDto> findAll();
    Mono<ProductResponseDto> create(CreateProductRequestDto createProductRequestDto);
}
