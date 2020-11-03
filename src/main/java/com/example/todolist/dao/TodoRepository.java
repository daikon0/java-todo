package com.example.todolist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
  List<TodoEntity> findByTitleContaining(String searchWord);
  List<TodoEntity> findAllByOrderByCreateTimeDesc();
}
