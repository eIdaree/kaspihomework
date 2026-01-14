package kz.eldar.kaspihomework.kaspihomework.controllers;

import jakarta.validation.Valid;
import kz.eldar.kaspihomework.kaspihomework.exceptions.NotFoundException;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.CreateProductRequestDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.ProductResponseDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.UpdateProductRequestDto;
import kz.eldar.kaspihomework.kaspihomework.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponseDto create(@Valid @RequestBody CreateProductRequestDto productDto) {
        return productService.create(productDto);
    }

    @GetMapping
    public List<ProductResponseDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable Long id) {
        return productService.getById(id).orElseThrow(() -> new NotFoundException("Product", id));
    }

    @PatchMapping("/{id}")
    public ProductResponseDto update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateProductRequestDto productDto
    ) {
        return productService.update(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}

