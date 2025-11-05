package com.example.quizapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class quiz {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String title;

@ManyToMany
@JoinTable(
    name = "quiz_questions",
    joinColumns = @JoinColumn(name = "quiz_id"),
    inverseJoinColumns = @JoinColumn(name = "questions_id")
)
private List<questions> questions;
}
