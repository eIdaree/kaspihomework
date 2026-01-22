package kz.eldar.product_service.productserviceflux.mappers;

import kz.eldar.product_service.productserviceflux.entities.Product;
import kz.eldar.product_service.productserviceflux.models.payload.product.CreateProductRequestDto;
import kz.eldar.product_service.productserviceflux.models.payload.product.ProductResponseDto;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(CreateProductRequestDto createProductRequestDto);

    ProductResponseDto toResponse(Product product);

    List<ProductResponseDto> toResponseList(List<Product> products);
}
