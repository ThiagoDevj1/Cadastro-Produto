package com.projetobackend.product_backend.Resourcers;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projetobackend.product_backend.models.Category;



@RestController
@CrossOrigin
public class CategoryControler {
    
    private List<Category> categories = Arrays.asList( new Category(1,"Produção Própria"),
                                                       new Category(2,"Nacional"),
                                                       new Category(3,"Importado"),
                                                       new Category(4,"Premium")
    );

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        Category cat = categories.stream()
                                .filter(p -> p.getId() == id)
                                .findFirst()
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        
        
        return ResponseEntity.ok(cat);
    }

    @GetMapping("categories")
    public List<Category> getCategories() {
        return categories;
    }
    
}