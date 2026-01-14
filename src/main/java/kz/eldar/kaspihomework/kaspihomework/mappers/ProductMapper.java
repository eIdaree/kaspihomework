package kz.eldar.kaspihomework.kaspihomework.mappers;
import kz.eldar.kaspihomework.kaspihomework.business.Product;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.CreateProductRequestDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.ProductResponseDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.product.UpdateProductRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

//    ProductDto toDto(Product product);

//    Product toEntity(ProductDto productDto);

    Product toEntity(CreateProductRequestDto createProductRequestDto);

    ProductResponseDto toResponse(Product product);
}
