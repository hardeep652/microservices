package com.example.quizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.Service.questionservice;
import com.example.quizapp.model.questions;

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

    
}
