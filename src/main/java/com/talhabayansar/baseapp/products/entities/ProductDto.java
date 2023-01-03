package com.talhabayansar.baseapp.products.entities;

import com.talhabayansar.baseapp.clients.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    @NotNull(message = "Name property can not be null.")
    @NotEmpty(message = "Name property can not be empty.")
    @NotBlank(message = "Name property can not be blank.")
    private String name;
    @NotNull(message = "Description property can not be null.")
    @NotEmpty(message = "Description property can not be empty.")
    @NotBlank(message = "Description property can not be blank.")
    private String description;
    @NotNull(message = "Product code property can not be null.")
    @NotEmpty(message = "Product code property can not be empty.")
    @NotBlank(message = "Product code property can not be blank.")
    private String productCode;
    @NotNull(message = "Client property can not be null.")
    private Integer clientId;

    public Product toProduct() {
        return new Product(null, getName(), getDescription(), getProductCode(), null);
    }
}
