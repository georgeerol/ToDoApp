package com.todo.rest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by George Fouche on 7/6/19.
 */
public class BCryptEncoderTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedString = encoder.encode("erol");
        System.out.println(encodedString);

    }
}
