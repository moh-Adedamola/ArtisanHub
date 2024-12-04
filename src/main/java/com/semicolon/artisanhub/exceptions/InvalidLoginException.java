package com.semicolon.artisanhub.exceptions;

public class InvalidLoginException extends RuntimeException{
    public InvalidLoginException(String message){
        super("Invalid Login Response: "+message);
    }
}
