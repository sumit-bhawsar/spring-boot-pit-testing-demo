package com.sb.spring_boot_pit_testing_demo.service.impl;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sb.spring_boot_pit_testing_demo.exception.InvalidValueException;
import com.sb.spring_boot_pit_testing_demo.exception.NotFoundException;
import com.sb.spring_boot_pit_testing_demo.repository.ProductRepository;

import com.sb.spring_boot_pit_testing_demo.repository.entity.Product;
import com.sb.spring_boot_pit_testing_demo.service.dto.ProductDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest extends Assertions {

    @Mock
    private ProductRepository productRepository;

    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void testGetProductById_InvalidId() {
        assertThrows(InvalidValueException.class, () -> productService.getProductById(0L));
    }

    @Test
    public void testGetProductById_ProductNotFound() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> productService.getProductById(1L));
    }

    @Test
    public void testGetProductById_Success() {
        Product product = new Product();
        product.setId(1L);
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        ProductDTO result = productService.getProductById(2L);

        assertEquals(1L, result.getId());
    }

    @Test
    public void testGetAllProducts_NoProductsFound() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());

        assertThrows(NotFoundException.class, () -> productService.getAllProducts());
    }

    @Test
    public void testGetAllProducts_Success() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setId(1L);
        products.add(product1);
        Product product2 = new Product();
        product2.setId(2L);
        products.add(product2);
        when(productRepository.findAll()).thenReturn(products);

        List<ProductDTO> result = productService.getAllProducts();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
    }

    @Test
    public void testSaveProduct_InvalidId() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(0L);

        assertThrows(InvalidValueException.class, () -> productService.saveProduct(productDTO));
    }

    @Test
    public void testSaveProduct_InvalidId_minus1() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(-1L);

        assertThrows(InvalidValueException.class, () -> productService.saveProduct(productDTO));
    }

    @Test
    public void testSaveProduct_InvalidName() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("123");

        assertThrows(InvalidValueException.class, () -> productService.saveProduct(productDTO));
    }

    @Test
    public void testSaveProduct_NullPrice() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Test Product");

        assertThrows(InvalidValueException.class, () -> productService.saveProduct(productDTO));
    }

    @Test
    public void testSaveProduct_NegativePrice() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Test Product");
        productDTO.setPrice(BigDecimal.valueOf(-10));

        assertThrows(InvalidValueException.class, () -> productService.saveProduct(productDTO));
    }

    @Test
    public void testSaveProduct_Success() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Test Product");
        productDTO.setPrice(BigDecimal.ONE);

        productService.saveProduct(productDTO);

        verify(productRepository, times(1)).saveAndFlush(any(Product.class));
    }
}
