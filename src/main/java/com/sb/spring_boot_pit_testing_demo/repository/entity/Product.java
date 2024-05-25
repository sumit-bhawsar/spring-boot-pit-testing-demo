package com.sb.spring_boot_pit_testing_demo.repository.entity;

import com.sb.spring_boot_pit_testing_demo.service.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    public Product(ProductDTO product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}