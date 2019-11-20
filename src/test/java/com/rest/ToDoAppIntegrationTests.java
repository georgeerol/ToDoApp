package com.rest;


import com.rest.todo.model.Todo;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${jwt.test.token}")
    private String token;


    @Test
    public void whenGetAllToDos_thenOK() {
        System.out.println("george");
        System.out.println(token);
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
    public void whenGetASpecificTodo_thenNotFound() {
        String api = "http://localhost:" + port + "/users/georgeerol/todos/101";
        Response response = given().port(port).auth().oauth2(token).get(api);
        assertEquals(response.body().print(),"Todo not found");
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());

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

    @Test
    public void whenUpdateTodo_thenUpdate() {
        String api = "http://localhost:" + port + "/users/georgeerol/todos/10001";
        Todo todo = createRandomTodo();
        Response response = given().
                port(port).
                auth().oauth2(token).
                contentType(MediaType.APPLICATION_JSON_VALUE).
                body(todo).
                put(api);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }


    @Test
    public void whenDelete_ThenOK(){
        String api = "http://localhost:" + port + "/users/georgeerol/todos/10002";
        Response response = given().port(port).auth().oauth2(token).delete(api);
        assertEquals(HttpStatus.OK.value(),response.getStatusCode());
    }

    @Test
    public void whenDelete_ThenNotFound(){
        String api = "http://localhost:" + port + "/users/georgeerol/todos/102";
        Response response = given().port(port).auth().oauth2(token).delete(api);
        assertEquals(response.body().print(),"Todo not found");
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    private Todo createRandomTodo() {
        Todo todo = new Todo();
        todo.setUsername(randomAlphabetic(10));
        todo.setDescription(randomAlphabetic(10));
        todo.setTargetDate(new Date());
        todo.setDone(true);
        return todo;
    }




}
