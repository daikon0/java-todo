package com.example.todolist;

import com.example.todolist.dao.TodoRepository;
import com.example.todolist.dao.TodoEntity;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public TodoEntity findTodoById(long todoId) {
    Optional<TodoEntity> todoResult = todoRepository.findById(todoId);
    return todoResult.get();
  }

  public void switchTodo(long todoId) {
    TodoEntity todoEntity = findTodoById(todoId);
    todoEntity.setStatus(!todoEntity.getStatus());
    todoRepository.save(todoEntity);
  }

  public void updateTodo(long todoId, String title) {
    TodoEntity todoEntity = findTodoById(todoId);
    todoEntity.setTitle(title);
    todoRepository.save(todoEntity);
  }

  public void deleteTodo(long todoId) {
    TodoEntity todoEntity = findTodoById(todoId);
    todoRepository.delete(todoEntity);
  }
}
