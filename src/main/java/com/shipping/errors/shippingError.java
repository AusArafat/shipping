package com.shipping.errors;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class shippingError {

    private HttpStatus status;
    private int errorCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private List<String> fieldErrors;

    private shippingError(){
        timestamp = LocalDateTime.now();
    }

    shippingError(HttpStatus status){
        this();
        this.status = status;
        this.errorCode = status.value();
    }

    shippingError(HttpStatus status, String message){
        this();
        this.status = status;
        this.errorCode = status.value();
        this.message = message;
    }

    shippingError(HttpStatus status, String message, Throwable ex){
        this();
        this.status = status;
        this.errorCode = status.value();
        this.message = message;
        this.fieldErrors.add(ex.getMessage());
    }

    shippingError(HttpStatus status, String message, List<String> fieldErrors){
        this();
        this.status = status;
        this.errorCode = status.value();
        this.message = message;
        this.fieldErrors = fieldErrors;
    }


    public HttpStatus getStatus() {
        return this.status;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getfieldErrors() {
        return fieldErrors;
    }

}
