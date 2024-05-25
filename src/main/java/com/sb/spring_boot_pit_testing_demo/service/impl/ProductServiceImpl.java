package com.sb.spring_boot_pit_testing_demo.service.impl;

import com.sb.spring_boot_pit_testing_demo.exception.InvalidValueException;
import com.sb.spring_boot_pit_testing_demo.exception.NotFoundException;
import com.sb.spring_boot_pit_testing_demo.repository.ProductRepository;
import com.sb.spring_boot_pit_testing_demo.repository.entity.Product;
import com.sb.spring_boot_pit_testing_demo.service.ProductService;
import com.sb.spring_boot_pit_testing_demo.service.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import static org.springframework.util.CollectionUtils.isEmpty;
import static org.springframework.util.StringUtils.hasText;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private Pattern productName = Pattern.compile("^([0-9A-Za-z ]+)$");

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        if(productId<=1){
            throw new InvalidValueException("id");
        }
        Optional<Product> product = productRepository.findById(productId);
        if(!product.isPresent()){
            throw new NotFoundException(productId.toString());
        }
        return new ProductDTO();
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(isEmpty(products)){
            throw new NotFoundException();
        }
        return products.stream().map(product -> new ProductDTO(product)).toList();
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {
        if(productDTO.getId() <=0){
            throw new InvalidValueException("id");
        }
        if(!hasText(productDTO.getName()) || !productName.matcher(productDTO.getName()).matches()){
            throw new InvalidValueException("name");
        }
        if(productDTO.getPrice() == null || productDTO.getPrice().longValue() <=0){
            throw new InvalidValueException("price");
        }

        productRepository.saveAndFlush(new Product(productDTO));
    }
}
