package com.example.demo.dto;
import com.example.demo.entity.Todo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoDTO {
    private Long id;
    private String title;
    private boolean completed;

    public TodoDTO() {}

    public TodoDTO(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public static TodoDTO toDTO(Todo todoEntity) {
        return new TodoDTO(
            todoEntity.getId(),
            todoEntity.getTitle(),
            todoEntity.isCompleted()
        );
    }

    public static Todo toEntity(TodoDTO dto) {
        Todo todo = new Todo();
        todo.setId(dto.getId());
        todo.setTitle(dto.getTitle());
        todo.setCompleted(dto.isCompleted());
        return todo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
