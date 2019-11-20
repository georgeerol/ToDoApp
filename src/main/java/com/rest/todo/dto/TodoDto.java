package com.rest.todo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by George Fouche on 11/20/19.
 */
@NoArgsConstructor
@Data
public class TodoDto {
    private Long id;
    private String description;
    private Date targetDate;
    private boolean isDone;
}
