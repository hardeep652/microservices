package com.example.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionservice.model.Response;
import com.example.questionservice.model.questions;
import com.example.questionservice.service.questionservice;

@RestController
@RequestMapping("/api/questions")
public class questioncontroller {

    @Autowired
    private questionservice questionservice;

    @GetMapping("/sample")
    public String getsample()
    {
        return "Sample Question";
    }

    @GetMapping("/interview")
    public List<questions> getinterviewquestions()
    {
        return questionservice.getAllquestions();
    }
    
    @GetMapping("/{category}")
    public List<questions> getQuestionsByCategory(@PathVariable String category) {
        String formattedCategory = category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();
        return questionservice.getQuestionsByCategory(formattedCategory);
    }

    @PostMapping("/add")
    public String addquestion(@RequestBody questions question)
    {
       questionservice.addQuestion(question);
         return "Question added successfully";
    }   

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getquestionsforquiz(@RequestParam String category, @RequestParam int numQ)
    {
        return questionservice.getquestionsforquiz(category, numQ);
    }

    @PostMapping("/score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return questionservice.calculateScore(responses);
    }

    
    
}
