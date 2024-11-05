package com.projetobackend.product_backend.Resourcers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @GetMapping("Hello")
    public String getHello(){
        return "Hello SpringBoot";
    }

    
}
