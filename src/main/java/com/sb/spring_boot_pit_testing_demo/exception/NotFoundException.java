package com.sb.spring_boot_pit_testing_demo.exception;

import static org.springframework.util.StringUtils.hasText;

public class NotFoundException extends RuntimeException{

    private String productId;
    public NotFoundException(String productId){
        this.productId = productId;
    }

    public NotFoundException(){
        this.productId = null;
    }

    @Override
    public String getMessage(){
        if(hasText(productId)){
            return "Product not found with the ID " +productId;
        } else {
            return "Products not found";
        }
    }
}
