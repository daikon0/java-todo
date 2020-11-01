package com.example.todolist;

import java.util.List;

import com.example.todolist.dao.TodoEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {
  private final TodoService todoService;

  @GetMapping("/")
  public String todo(Model model) {
    List<TodoEntity> todoEntityList = todoService.findAllTodo();
    model.addAttribute("todoList", todoEntityList);
    return "index";
  }

  @PostMapping("/register")
  public String register(@ModelAttribute TodoForm formData) {
    todoService.setTodo(formData);
    return "redirect:/";
  }
}
