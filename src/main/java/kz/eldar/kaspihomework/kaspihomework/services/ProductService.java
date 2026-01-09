package kz.eldar.kaspihomework.kaspihomework.services;

import kz.eldar.kaspihomework.kaspihomework.business.Product;
import kz.eldar.kaspihomework.kaspihomework.data.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product update(Long id, Product updated) {
        Product existing = getById(id);
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        return productRepository.save(existing);
    }

    public void delete(Long id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found");
        }
    }


}
