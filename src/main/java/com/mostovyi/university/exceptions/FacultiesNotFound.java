package com.mostovyi.university.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FacultiesNotFound extends RuntimeException {

    public FacultiesNotFound(String message) { super(message); }
}
