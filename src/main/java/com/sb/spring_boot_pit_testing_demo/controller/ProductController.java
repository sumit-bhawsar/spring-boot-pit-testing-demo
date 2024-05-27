package com.sb.spring_boot_pit_testing_demo.controller;

import com.sb.spring_boot_pit_testing_demo.service.ProductService;
import com.sb.spring_boot_pit_testing_demo.service.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProductById(@PathVariable Long productId) {
        ProductDTO productDTO = productService.getProductById(productId);
        return productDTO;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return products;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveProduct(@RequestBody ProductDTO productDTO) {
        productService.saveProduct(productDTO);
    }
}
