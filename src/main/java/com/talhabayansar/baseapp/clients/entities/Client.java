package com.talhabayansar.baseapp.clients.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.talhabayansar.baseapp.products.entities.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
    @SequenceGenerator(name = "client_generator", sequenceName = "client_seq", initialValue = 0, allocationSize = 1)
    private Integer id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String city;
    private String email;
    private String zip;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    @JsonManagedReference
    private List<Product> products;
}
