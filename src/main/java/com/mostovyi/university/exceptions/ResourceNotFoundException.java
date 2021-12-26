package com.mostovyi.university.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String employee, String value, Long id) {
        super(String.format("%s with following %s : %d is not found!", employee, value, id));
    }


}
