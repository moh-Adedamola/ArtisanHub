package com.semicolon.artisanhub.exceptions;

public class UsersAlreadyExistExceptions extends RuntimeException{
    public UsersAlreadyExistExceptions(String message){
        super(message);
    }
}
