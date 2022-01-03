package com.shipping.errors;

public class carrierIdNotFoundException extends Exception{
    public carrierIdNotFoundException(String message){
        super(message);
    }
    public carrierIdNotFoundException(String message, Throwable error){
        super(message, error);
    }
}
