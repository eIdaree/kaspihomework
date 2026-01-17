package kz.eldar.kaspihomework.kaspihomework.services;

import kz.eldar.kaspihomework.kaspihomework.models.ProductDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.CreateProductRequestDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.ProductResponseDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.UpdateProductRequestDto;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ProductService {
    ProductResponseDto create(CreateProductRequestDto productDto);
    CompletableFuture<List<ProductResponseDto>> getAll();
    Optional<ProductResponseDto> getById(Long id);
    ProductResponseDto update(Long id, UpdateProductRequestDto updated);
    void delete(Long id);
}
