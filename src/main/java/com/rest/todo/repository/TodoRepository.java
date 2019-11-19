package com.rest.todo.repository;

import com.rest.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by George Fouche on 10/25/19.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{
    List<Todo> findByUsername(String username);


}
