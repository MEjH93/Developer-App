package com.netcare.customexception;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {

    private String message;
    private Integer id;
    private HttpStatus httpStatus;

    public CustomException(String message, Integer id, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.id = id;
        this.httpStatus = httpStatus;
    }


    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        if (id != null)
            return message + id;
        else
            return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
