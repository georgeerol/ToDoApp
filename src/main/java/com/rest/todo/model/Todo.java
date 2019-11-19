package com.rest.todo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by George Fouche on 6/18/19.
 */


@NoArgsConstructor
@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;


}
