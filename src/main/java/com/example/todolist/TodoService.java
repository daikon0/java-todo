package com.example.todolist;

import com.example.todolist.dao.TodoRepository;
import com.example.todolist.dao.TodoEntity;

import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
  private final TodoRepository todoRepository;

  public List<TodoEntity> findAllTodo() {
    return todoRepository.findAll();
  }

  public void setTodo(TodoForm formDate) {
    TodoEntity todo = new TodoEntity();
    todo.setTitle(formDate.getTitle());
    todo.setDeadline(formDate.getDeadline());
    todo.setStatus(false);
    todoRepository.save(todo);
  }
}
