package com.example.quizapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapp.Repository.questionrepo;
import com.example.quizapp.Repository.quizrepository;
import com.example.quizapp.model.Response;
import com.example.quizapp.model.questions;
import com.example.quizapp.model.quiz;

@Service
public class quizservice {
    
    @Autowired
    private questionrepo questionrepo;
    
    @Autowired
    private quizrepository quizrepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<questions> questionList = questionrepo.findRandomQuestionsByCategory(category, numQ);

        quiz newQuiz = new quiz();
        newQuiz.setTitle(title);
        newQuiz.setQuestions(questionList);

        quizrepository.save(newQuiz);
        
        return ResponseEntity.ok("Quiz created successfully!");
    }

    public List<questions> getquizbyid(int id) {

    Optional<quiz> foundQuiz = quizrepository.findById(id);

    // Use a lambda instead of method reference
    List<questions> quizQuestions = foundQuiz.map(q -> q.getQuestions()).orElse(null);

    System.out.println("Quiz found: " + quizrepository.findById(id));


    return quizQuestions;
}

    public ResponseEntity<Integer> calculateresult(int id, List<Response> response) {
        int score = 0;
        quiz foundQuiz = quizrepository.findById(id).orElse(null);
        List<questions> quizQuestions = foundQuiz.getQuestions();
        int i=0;
        for(Response res : response)
        {
            if(res.getResponse().equals(quizQuestions.get(i).getRightanswer()))
            {
                score++;
            }
            i++;
        }

        return ResponseEntity.ok(score);
        

        
    }



}
