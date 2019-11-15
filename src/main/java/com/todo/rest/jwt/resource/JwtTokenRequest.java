package com.todo.rest.jwt.resource;

import java.io.Serializable;

/**
 * Created by George Fouche on 7/6/19.
 */
public class  JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;
//
//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU2MzA1NDcwNCwiaWF0IjoxNTYyNDQ5OTA0fQ.aftEbG05noADYexqPC5PFrFty6xt-C1BNSzMhrgq-bsPiEOebqlurZOUNYEp_3GJg4kQB5qLstsDkxtADpqsfw";
//    }


    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

