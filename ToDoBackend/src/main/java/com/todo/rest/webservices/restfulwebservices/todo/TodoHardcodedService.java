package com.todo.rest.webservices.restfulwebservices.todo;

import com.todo.rest.webservices.restfulwebservices.todo.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by George Fouche on 6/20/19.
 */

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<>();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "GeorgeErol", "Learn to dance", new Date(), false));
        todos.add(new Todo(++idCounter, "GeorgeErol", "Learn about Micro Services ", new Date(), false));
        todos.add(new Todo(++idCounter, "GeorgeErol", "Learn about Angular", new Date(), false));

    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo == null) return null;
        if (todos.remove(todo)) return todo;
        return null;

    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
