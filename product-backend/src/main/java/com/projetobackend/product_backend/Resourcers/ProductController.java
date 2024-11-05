package com.projetobackend.product_backend.Resourcers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projetobackend.product_backend.models.Product;



@RestController
public class ProductController {

    private List<Product> products = Arrays.asList(new Product(1, "Product 01", 99.90),
                                                   new Product(2, "Product 02", 99.90),
                                                   new Product(3, "Product 03", 99.90)
    );

   

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {

        Product prod = products.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        
        return ResponseEntity.ok(prod);                

    }

    @GetMapping("products")
    public List<Product> getProducts() {

        return products;

    }

}
