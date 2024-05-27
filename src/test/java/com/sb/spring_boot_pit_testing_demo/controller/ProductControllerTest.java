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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productController = new ProductController(productService);
    }

    @Test
    public void testGetProductById() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        when(productService.getProductById(1L)).thenReturn(productDTO);

        ProductDTO responseEntity = productController.getProductById(1L);

        assertEquals(1L, responseEntity.getId());
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

        List<ProductDTO> responseEntity = productController.getAllProducts();


        assertEquals(2, responseEntity.size());
        assertEquals(1L, responseEntity.get(0).getId());
        assertEquals(2L, responseEntity.get(1).getId());
    }

    @Test
    public void testSaveProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Test Product");
        productDTO.setPrice(BigDecimal.TEN);

        doNothing().when(productService).saveProduct(any(ProductDTO.class));

        productController.saveProduct(productDTO);

        verify(productService, times(1)).saveProduct(any(ProductDTO.class));
    }
}
