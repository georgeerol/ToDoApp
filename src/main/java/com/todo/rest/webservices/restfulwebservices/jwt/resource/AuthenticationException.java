package com.todo.rest.webservices.restfulwebservices.jwt.resource;

/**
 * Created by George Fouche on 7/6/19.
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
