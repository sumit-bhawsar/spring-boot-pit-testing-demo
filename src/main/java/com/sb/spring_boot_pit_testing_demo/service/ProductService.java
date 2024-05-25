package com.sb.spring_boot_pit_testing_demo.service;

import com.sb.spring_boot_pit_testing_demo.service.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Long productId);
    List<ProductDTO> getAllProducts();
    void saveProduct(ProductDTO product);
}
