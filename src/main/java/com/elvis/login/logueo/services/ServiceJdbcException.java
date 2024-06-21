package com.elvis.login.logueo.services;

public class ServiceJdbcException extends RuntimeException {

    public ServiceJdbcException(String message){
        super(message);
    }
    public ServiceJdbcException( String message, Throwable cause){
        super(message, cause);
    }
}
