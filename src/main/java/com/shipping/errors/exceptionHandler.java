package com.shipping.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class exceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(exceptionHandler.class); 

    private ResponseEntity<Object> buildEntity(shippingError shippingError){
        return new ResponseEntity<>(shippingError, shippingError.getStatus());
    }
    
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("HttpMessageNotReadable", ex);
        String error = "Malformed JSON request";
        List<String> fieldErrorList = new ArrayList<String>();
        fieldErrorList.add(ex.getMessage());
        return buildEntity( new shippingError(status, error, fieldErrorList));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Invalid request paramaeter(s)";
        List<FieldError> fieldErrors = ex.getFieldErrors();
        List<String> errArgs = new ArrayList<String>();
        for (FieldError fieldError : fieldErrors) {
             errArgs.add(fieldError.getField() + " : " + fieldError.getDefaultMessage());
        }
        return buildEntity(new shippingError(status, error, errArgs));
    }

    @ExceptionHandler(carrierIdNotFoundException.class)
    protected ResponseEntity<Object> handleCarrierIdNotFoundException(carrierIdNotFoundException ex){
        List<String> fieldErrorList = new ArrayList<String>();
        fieldErrorList.add("carrierID : " + ex.getMessage());
        String error = "Invalid CarrierId";
        return buildEntity(new shippingError(HttpStatus.BAD_REQUEST, error, fieldErrorList));
    }
}   
