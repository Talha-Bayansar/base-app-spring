package com.talhabayansar.baseapp.products.controllers;

import com.talhabayansar.baseapp.clients.entities.Client;
import com.talhabayansar.baseapp.clients.entities.ClientDto;
import com.talhabayansar.baseapp.products.entities.Product;
import com.talhabayansar.baseapp.products.entities.ProductDto;
import com.talhabayansar.baseapp.products.services.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsServiceImpl productsService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll(@RequestParam(value = "limit", required = false, defaultValue = "") String limit,
                                                    @RequestParam(value = "offset", required = false, defaultValue = "0") String offset) {
        return ResponseEntity.ok(this.productsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.productsService.findOne(id));
    }

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody ProductDto body) {
        Product product = this.productsService.create(body);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Integer id, @RequestBody ProductDto body) {
        Product product = this.productsService.update(id, body);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> remove(@PathVariable("id") Integer id) {
        Product product = this.productsService.remove(id);
        return ResponseEntity.ok(product);
    }
}
