package com.example.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class TodoControllerAdvice {
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(TodoNotFoundException.class)
  public String isNotFound() {
    log.warn("指定されたTODOが見つかりません。");
    return "error/404.html";
  }

  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public String badMethod() {
    log.warn("Bad Request");
    return "error/405.html";
  }
}
