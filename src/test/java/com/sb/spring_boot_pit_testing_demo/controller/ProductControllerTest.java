package com.sb.spring_boot_pit_testing_demo.controller;

import com.sb.spring_boot_pit_testing_demo.service.ProductService;
import com.sb.spring_boot_pit_testing_demo.service.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProductById() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        when(productService.getProductById(1L)).thenReturn(productDTO);

        ResponseEntity<ProductDTO> responseEntity = productController.getProductById(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1L, responseEntity.getBody().getId());
    }

    @Test
    public void testGetAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setId(1L);
        products.add(productDTO1);
        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setId(2L);
        products.add(productDTO2);
        when(productService.getAllProducts()).thenReturn(products);

        ResponseEntity<List<ProductDTO>> responseEntity = productController.getAllProducts();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().size());
        assertEquals(1L, responseEntity.getBody().get(0).getId());
        assertEquals(2L, responseEntity.getBody().get(1).getId());
    }

    @Test
    public void testSaveProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Test Product");
        productDTO.setPrice(BigDecimal.TEN);

        ResponseEntity<Void> responseEntity = productController.saveProduct(productDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
}
