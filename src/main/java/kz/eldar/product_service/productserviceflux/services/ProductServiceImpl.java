package kz.eldar.product_service.productserviceflux.services;

import kz.eldar.product_service.productserviceflux.client.DeliveryWebClient;
import kz.eldar.product_service.productserviceflux.entities.Product;
import kz.eldar.product_service.productserviceflux.mappers.ProductMapper;
import kz.eldar.product_service.productserviceflux.models.payload.delivery.CreateDeliveryRequestDto;
import kz.eldar.product_service.productserviceflux.models.payload.product.CreateProductRequestDto;
import kz.eldar.product_service.productserviceflux.models.payload.product.ProductResponseDto;
import kz.eldar.product_service.productserviceflux.repos.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final DeliveryWebClient deliveryClient;


    @Override
    public Mono<ProductResponseDto> create(CreateProductRequestDto requestDto) {
        log.debug("Create product request: {}", requestDto);
        return Mono.just(requestDto)
                .map(productMapper::toEntity)
                .flatMap(productRepository::save)
                .flatMap(savedProduct -> {
                    CreateDeliveryRequestDto deliveryRequest = new CreateDeliveryRequestDto(
                            savedProduct.getId(),
                            savedProduct.getAddress()
                    );

                    return deliveryClient.createDelivery(deliveryRequest)
                            .map(delivery -> savedProduct)
                            .onErrorResume(ex ->
                                    productRepository.deleteById(savedProduct.getId())
                                            .then(Mono.error(ex))
                                    )
                            .map(productMapper::toResponse);
                });
    }

    @Override
    public Mono<ProductResponseDto> findById(Long id) {
        return productRepository.findById(id).map(productMapper::toResponse);
    }

    @Override
    public Flux<ProductResponseDto> findAll() {
        return productRepository.findAll().map(productMapper::toResponse);
    }


}
