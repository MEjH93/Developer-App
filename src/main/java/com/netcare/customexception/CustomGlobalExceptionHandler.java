package com.netcare.customexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomResponse> customHandleNotFound(CustomException ex) {
        CustomResponse errors = new CustomResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(ex.getHttpStatus().value());
        errors.setStatusName(ex.getHttpStatus().name());
        logger.error(ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

    }
}
