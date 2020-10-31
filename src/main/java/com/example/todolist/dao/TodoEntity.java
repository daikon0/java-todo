package com.example.todolist.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "todo")
public class TodoEntity {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "deadline")
  private LocalDate deadline;

  @Column(name = "status")
  private Boolean status;

  @CreationTimestamp
  @Column(name = "create_time")
  private LocalDateTime createTime;

  @UpdateTimestamp
  @Column(name = "update_time")
  private LocalDateTime updateTime;
}
