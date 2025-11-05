package com.example.quizapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.Repository.questionrepo;
import com.example.quizapp.model.questions;

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


  
}
