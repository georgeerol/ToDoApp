package com.rest.todo.controller;

import com.rest.todo.dto.TodoDto;
import com.rest.todo.exception.TodoNotFoundException;
import com.rest.todo.model.Todo;
import com.rest.todo.repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;


    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {

        todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        todoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody TodoDto todoDto) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDto,todo);
        todo.setUsername(username);
        Todo todoUpdated = todoRepository.save(todo);
        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody TodoDto todoDto) {

        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDto, todo);
        todo.setUsername(username);
        Todo createdTodo = todoRepository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}


