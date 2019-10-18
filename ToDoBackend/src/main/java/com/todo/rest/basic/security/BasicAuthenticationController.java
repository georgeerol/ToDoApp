package com.todo.rest.basic.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by George Fouche on 6/17/19.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController {


    @GetMapping(path = "/basicauth")
    public AuthenticationBean authenticate() {
        return new AuthenticationBean("You are authenticated");
    }

    //
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public AuthenticationBean helloWorldPathVariable(@PathVariable String name) {
        //throw new RuntimeException("Something went wrong");
        return new AuthenticationBean(String.format("Hello World, %s", name));
    }

}
