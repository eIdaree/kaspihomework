package kz.eldar.kaspihomework.kaspihomework.controllers;

import kz.eldar.kaspihomework.kaspihomework.business.Product;
import kz.eldar.kaspihomework.kaspihomework.services.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PatchMapping("/{id}")
    public Product update(
            @PathVariable Long id,
            @RequestBody Product product
    ) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

