package kz.eldar.kaspihomework.kaspihomework.services;

import jakarta.transaction.Transactional;
import kz.eldar.kaspihomework.kaspihomework.business.Product;
import kz.eldar.kaspihomework.kaspihomework.data.ProductRepository;
import kz.eldar.kaspihomework.kaspihomework.exceptions.NotFoundException;
import kz.eldar.kaspihomework.kaspihomework.feign.DeliveryClient;
import kz.eldar.kaspihomework.kaspihomework.mappers.ProductMapper;
import kz.eldar.kaspihomework.kaspihomework.models.ProductDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.delivery.CreateDeliveryRequestDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.CreateProductRequestDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.ProductResponseDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.UpdateProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final DeliveryClient deliveryClient;

    @Transactional
    @Override
    public ProductResponseDto create(CreateProductRequestDto productDto){
        Product product = productMapper.toEntity(productDto);
        Product saved = productRepository.save(product);

        CreateDeliveryRequestDto deliveryRequest = new CreateDeliveryRequestDto(
                saved.getId(),
                saved.getAddress()
        );

        try {
            deliveryClient.createDelivery(deliveryRequest);
        } catch (Exception ex) {
            throw new RuntimeException("Delivery service failed", ex);
        }
        return productMapper.toResponse(saved);
    }

    @Override
    public List<ProductResponseDto> getAll(){
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<ProductResponseDto> getById(Long id){
        return Optional.ofNullable(
                productMapper.toResponse(
                        productRepository
                                .findById(id)
                                .orElse(null)
                )
        );
    }

    @Override
    public ProductResponseDto update(Long id, UpdateProductRequestDto updated) {
        Product existing = productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Product", id));
        existing.setName(updated.name());
        existing.setPrice(updated.price());
        Product saved = productRepository.save(existing);
        return productMapper.toResponse(saved);
    }

    public void delete(Long id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}
