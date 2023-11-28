package com.nocountry.S12G15.exception;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(){
    }

    public ObjectNotFoundException(String message){
        super(message);
    }
}
