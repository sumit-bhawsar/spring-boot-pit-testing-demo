package com.sb.spring_boot_pit_testing_demo.exception;

import static org.springframework.util.StringUtils.hasText;

public class InvalidValueException extends RuntimeException{

    private String field;
    public InvalidValueException(String field){
        this.field = field;
    }
    @Override
    public String getMessage(){
        return "invalid value provided for the field "+ field;
    }
}
