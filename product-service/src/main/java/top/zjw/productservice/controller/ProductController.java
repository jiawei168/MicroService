package top.zjw.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/product")
    public String getProduct(@RequestParam String product){
        return "Product: " + product;
    }
}
