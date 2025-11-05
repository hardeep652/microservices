package com.example.questionservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.questionservice.model.Response;
import com.example.questionservice.model.questions;
import com.example.questionservice.repository.questionrepo;

@Service
public class questionservice {
    
    @Autowired
    private questionrepo questionrepo;

    public List<questions> getAllquestions() {
        return questionrepo.findAll();
    }

    public List<questions> getQuestionsByCategory(String category)
    {
        return questionrepo.findByCategory(category);
    }
    public void addQuestion(questions question)
    {
        questionrepo.save(question);
    }

    public ResponseEntity<List<Integer>> getquestionsforquiz(String category, int numQ) {

        List<Integer> selectedQuestions = questionrepo.findRandomQuestionsByCategory(category, numQ);
        return new ResponseEntity<>(selectedQuestions, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateScore(List<Response> responses) {
        // TODO Auto-generated int score = 0;
        
        int i=0;
        for(Response res : responses)
        {
            questions ques = questionrepo.findById(res.getId()).orElse(null);
            if(res.getResponse().equals(ques.getRightanswer()))
            {
                i++;
            }
        }

        return ResponseEntity.ok(i);
    }




  
}
