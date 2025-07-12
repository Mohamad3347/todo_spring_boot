package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;

@Service
public class TodoService {
    

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    public boolean delete(Long id) {
        Optional<Todo> exist = repository.findById(id);
        if(exist.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
        
    }

    public boolean updateCompletedStatus(Long id, boolean status) {
        Optional<Todo> optional = repository.findById(id);
        if(optional.isPresent()) {
            Todo todo = optional.get();
            todo.setCompleted(status);
            repository.save(todo);
            return true;
        }
        return false;
    }
}
