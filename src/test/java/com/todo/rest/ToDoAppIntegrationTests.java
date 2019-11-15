package com.todo.rest;


import com.todo.rest.todo.model.Todo;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ToDoApp.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoAppIntegrationTests {

    @LocalServerPort
    private int port;
    private static final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2Vlcm9sIiwiZXhwIjoxNTc0Mzk0NzQwLCJpYXQiOjE1NzM3ODk5NDB9.1ShRJ6gscWPNQWRDjt2WzhI92xBmrnpu_sNDowQVbOTytYoF0QWNmDWoQh7FsD7QGbYYji7k8w2hewDgLLG-Bw";

    @Test
    public void whenGetAllToDos_thenOK() {
        String api = "http://localhost:" + port + "/users/georgeerol/todos";
        Response response = given().port(port).auth().oauth2(token).get(api);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetASpecificTodo_thenOK() {
        String api = "http://localhost:" + port + "/users/georgeerol/todos/10001";
        Response response = given().port(port).auth().oauth2(token).get(api);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

    }


    @Test
    public void whenCreateANewTodo_thenCreated() {
        String api = "http://localhost:" + port + "/users/georgeerol/todos";
        Todo todo = createRandomTodo();
        Response response = given().
                port(port).
                auth().oauth2(token).
                contentType(MediaType.APPLICATION_JSON_VALUE).
                body(todo).
                post(api);
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }


//    @Test
//    public void whenInvalidTodo_thenError() {
//        String api = "http://localhost:" + port + "/users/georgeerol/todos";
//        Todo todo = createRandomTodo();
//        todo.setUsername(null);
//        Response response = given().
//                port(port).
//                auth().oauth2(token).
//                contentType(MediaType.APPLICATION_JSON_VALUE).
//                body(todo).
//                post(api);
//        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
//    }




    private Todo createRandomTodo() {
        Todo todo = new Todo();
        todo.setUsername(randomAlphabetic(10));
        todo.setDescription(randomAlphabetic(10));
        todo.setTargetDate(new Date());
        todo.setDone(true);
        return todo;
    }




}
