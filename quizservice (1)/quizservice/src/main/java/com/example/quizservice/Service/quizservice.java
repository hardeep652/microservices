package com.example.quizservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizservice.Repository.quizrepository;
import com.example.quizservice.feign.Quizinterface;
import com.example.quizservice.model.Response;
import com.example.quizservice.model.quiz;

@Service
public class quizservice {
    
    @Autowired
    private quizrepository quizrepository;

    @Autowired
    Quizinterface quizinterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questionList = quizinterface.getquestionsforquiz(category, numQ).getBody();

        quiz quiz = new quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionList);
        quizrepository.save(quiz);

    //     quiz newQuiz = new quiz();
    //     newQuiz.setTitle(title);
    //     newQuiz.setQuestions(questionList);

    //     quizrepository.save(newQuiz);
        
        return ResponseEntity.ok("Quiz created successfully!");
    }

//     public List<questions> getquizbyid(int id) {

//     // Optional<quiz> foundQuiz = quizrepository.findById(id);

//     // // Use a lambda instead of method reference
//     // List<questions> quizQuestions = foundQuiz.map(q -> q.getQuestions()).orElse(null);

//     // System.out.println("Quiz found: " + quizrepository.findById(id));


//     // return quizQuestions;
// }

    public ResponseEntity<Integer> calculateresult(int id, List<Response> response) {
        int score = 0;
        // quiz foundQuiz = quizrepository.findById(id).orElse(null);
        // List<questions> quizQuestions = foundQuiz.getQuestions();
        // int i=0;
        // for(Response res : response)
        // {
        //     if(res.getResponse().equals(quizQuestions.get(i).getRightanswer()))
        //     {
        //         score++;
        //     }
        //     i++;
        // }

        return ResponseEntity.ok(score);
        

        
    }



}
