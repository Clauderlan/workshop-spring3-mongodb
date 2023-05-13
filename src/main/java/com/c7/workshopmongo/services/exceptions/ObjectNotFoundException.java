package com.c7.workshopmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String msg){
        super("Object not found, ID : " + msg);
    }
}
