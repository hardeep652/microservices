package com.example.quizservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizservice.Repository.quizrepository;
import com.example.quizservice.feign.Quizinterface;
import com.example.quizservice.model.Response;
import com.example.quizservice.model.quiz;

@Service
public class quizservice {

    @Autowired
    private quizrepository quizRepository;

    @Autowired
    Quizinterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        ResponseEntity<List<Integer>> response;
        try {
            response = quizInterface.getquestionsforquiz(category, numQ);
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to create quiz: " + e.getMessage());
        }
        List<Integer> questions = response.getBody();
        if (questions == null || questions.isEmpty()) {
            throw new RuntimeException("Failed to fetch questions for quiz");
        }

        quiz quiz = new quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);

    }

    // public List<questions> getquizbyid(int id) {

    // // Optional<quiz> foundQuiz = quizrepository.findById(id);

    // // // Use a lambda instead of method reference
    // // List<questions> quizQuestions = foundQuiz.map(q ->
    // q.getQuestions()).orElse(null);

    // // System.out.println("Quiz found: " + quizrepository.findById(id));

    // // return quizQuestions;
    // }

    public ResponseEntity<Integer> calculateresult(int id, List<Response> response) {
        int score = 0;
        // quiz foundQuiz = quizrepository.findById(id).orElse(null);
        // List<questions> quizQuestions = foundQuiz.getQuestions();
        // int i=0;
        // for(Response res : response)
        // {
        // if(res.getResponse().equals(quizQuestions.get(i).getRightanswer()))
        // {
        // score++;
        // }
        // i++;
        // }

        return ResponseEntity.ok(score);

    }

}
