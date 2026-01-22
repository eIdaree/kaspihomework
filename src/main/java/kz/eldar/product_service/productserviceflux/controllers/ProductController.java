package kz.eldar.product_service.productserviceflux.controllers;

import jakarta.validation.Valid;
import kz.eldar.product_service.productserviceflux.exceptions.NotFoundException;
import kz.eldar.product_service.productserviceflux.models.payload.product.CreateProductRequestDto;
import kz.eldar.product_service.productserviceflux.models.payload.product.ProductResponseDto;
import kz.eldar.product_service.productserviceflux.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v2/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Mono<ProductResponseDto> create(@Valid @RequestBody CreateProductRequestDto productDto) {
        return productService.create(productDto);
    }

    @GetMapping
    public Flux<ProductResponseDto> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ProductResponseDto> getById(@PathVariable Long id) {
        return productService.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Product", id)));
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @PatchMapping("/{id}")
//    public ProductResponseDto update(
//            @PathVariable Long id,
//            @Valid @RequestBody UpdateProductRequestDto productDto
//    ) {
//        return productService.update(id, productDto);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        productService.delete(id);
//    }
}

