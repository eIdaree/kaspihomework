package kz.eldar.kaspihomework.kaspihomework.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class ProductDto {

    @NotNull
    @NotBlank
    private String name;

    private BigDecimal price;


}
