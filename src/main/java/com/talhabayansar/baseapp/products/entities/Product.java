package com.talhabayansar.baseapp.products.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.talhabayansar.baseapp.clients.entities.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_seq", initialValue = 0, allocationSize = 1)
    private Integer id;
    private String name;
    private String description;
    private String productCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Client client;
}
