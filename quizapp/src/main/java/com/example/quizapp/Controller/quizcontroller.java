package com.example.quizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.Service.questionservice;
import com.example.quizapp.Service.quizservice;
import com.example.quizapp.model.Response;
import com.example.quizapp.model.questions;

@RestController
@RequestMapping("/api/quiz")
public class quizcontroller {

    @Autowired
    private quizservice quizservice;

    @Autowired
    private questionservice questionservice;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title) {
        // Logic to create a quiz
        return quizservice.createQuiz(category, numQ, title);
    }

    @GetMapping("/getquiz/{id}")
    public ResponseEntity<List<questions>> getquiz(@PathVariable int id)
    {
        List<questions> quizquestions = quizservice.getquizbyid(id);
        return org.springframework.http.ResponseEntity.ok(quizquestions);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> response)
    {
        return quizservice.calculateresult(id, response);
    }
}
