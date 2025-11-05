package com.example.quizservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizResponse {
    private String message;
    private List<QuestionWrapper> questions;
}
