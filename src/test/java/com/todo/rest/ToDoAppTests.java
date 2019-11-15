package com.todo.rest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ToDoApp.class}, webEnvironment
        = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ToDoAppTests {

    private static final String API_ROOT = "http://localhost:8087/users/georgeerol/todos";
    private static final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2Vlcm9sIiwiZXhwIjoxNTc0Mzk0NzQwLCJpYXQiOjE1NzM3ODk5NDB9.1ShRJ6gscWPNQWRDjt2WzhI92xBmrnpu_sNDowQVbOTytYoF0QWNmDWoQh7FsD7QGbYYji7k8w2hewDgLLG-Bw";



    @Test
    public void whenGetAllToDos_thenOK() {
        Response response = given().auth().oauth2(token).get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }





}
