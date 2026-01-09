package kz.eldar.kaspihomework.kaspihomework.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NotEmpty(message = "The name of a product can not be empty")
    String name;

    @DecimalMin(value = "10.00", message = "Price must be at least 10")
    @NotNull(message = "Price can not be null")
    BigDecimal price;
}
