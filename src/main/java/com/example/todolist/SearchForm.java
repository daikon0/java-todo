package com.example.todolist;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SearchForm {
  private Long id;
  @NotNull
  @Size(min = 0, max = 30)
  private String searchWord;
}
