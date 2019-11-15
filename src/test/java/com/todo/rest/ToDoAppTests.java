package com.todo.rest;


import io.restassured.response.Response;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ToDoApp.class}, webEnvironment
        = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoAppIT {

    private static final String API_ROOT = "http://localhost:8087/users/georgeerol/todos";
    private static final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2Vlcm9sIiwiZXhwIjoxNTc0Mzk0NzQwLCJpYXQiOjE1NzM3ODk5NDB9.1ShRJ6gscWPNQWRDjt2WzhI92xBmrnpu_sNDowQVbOTytYoF0QWNmDWoQh7FsD7QGbYYji7k8w2hewDgLLG-Bw";

    @LocalServerPort
    private int port;

    @Test
    public void whenGetAllToDos_thenOK() {
        String api = "http://localhost:"+port+"/users/georgeerol/todos";
        Response response = given().port(port).auth().oauth2(token).get(api);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }





}
