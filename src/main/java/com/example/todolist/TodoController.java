package com.example.todolist;

import java.util.List;

import com.example.todolist.dao.TodoEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @PostMapping("/update/{id}")
  public String update(@PathVariable("id") Long todoId, @RequestParam String title) {
    todoService.updateTodo(todoId, title);
    return "redirect:/";
  }

  @PatchMapping("/done/{id}")
  public String switchStatus(@PathVariable("id") Long todoId) {
    todoService.switchTodo(todoId);
    return "redirect:/";
  }

  @DeleteMapping("/delete/{id}")
  public String delete(@PathVariable("id") Long todoId) {
    todoService.deleteTodo(todoId);
    return "redirect:/";
  }
}
