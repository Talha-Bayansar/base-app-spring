package com.talhabayansar.baseapp.products.services;

import com.talhabayansar.baseapp.clients.entities.ClientDto;
import com.talhabayansar.baseapp.products.entities.Product;
import com.talhabayansar.baseapp.products.entities.ProductDto;

public interface ProductsService {
    Iterable<Product> findAll();
    Product findOne(Integer id);
    Product create(ProductDto productDto);
    Product update(Integer id, ProductDto productDto);
    Product remove(Integer id);
}
