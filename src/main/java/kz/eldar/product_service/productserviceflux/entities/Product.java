package kz.eldar.product_service.productserviceflux.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("product")
public class Product {
    @Id
    private Long id;

    private String name;

    private Double price;

    private String address;
}