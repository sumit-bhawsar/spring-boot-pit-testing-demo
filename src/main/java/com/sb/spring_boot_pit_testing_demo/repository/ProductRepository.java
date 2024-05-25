package com.sb.spring_boot_pit_testing_demo.repository;

import com.sb.spring_boot_pit_testing_demo.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods can be defined here if needed
}
