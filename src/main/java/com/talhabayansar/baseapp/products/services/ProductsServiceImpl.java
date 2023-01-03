package com.talhabayansar.baseapp.products.services;

import com.talhabayansar.baseapp.clients.entities.Client;
import com.talhabayansar.baseapp.clients.repositories.ClientRepository;
import com.talhabayansar.baseapp.products.entities.Product;
import com.talhabayansar.baseapp.products.entities.ProductDto;
import com.talhabayansar.baseapp.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Product create(ProductDto productDto) {
        try {
            productRepository.save(productDto.toProduct());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "The product couldn't be created.");
        }

        return productDto.toProduct();
    }

    @Override
    public Product update(Integer id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Optional<Client> optionalClient = clientRepository.findById(productDto.getClientId());
        if(optionalProduct.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There was no product found with the given ID.");
        }
        if(optionalClient.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "This product doesn't have a client.");
        }
        try {
            Client client = optionalClient.get();
            Product product = productDto.toProduct();
            product.setId(id);
            product.setClient(client);

            productRepository.save(product);
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Something went wrong when updating this product.");
        }

    }

    @Override
    public Product remove(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "The product you tried to remove doesn't exist.");
        }
        try {
            Product product = optionalProduct.get();
            productRepository.delete(product);
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "This product couldn't be removed.");
        }
    }
}
