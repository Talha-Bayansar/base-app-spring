package com.talhabayansar.baseapp.products.repositories;

import com.talhabayansar.baseapp.products.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
