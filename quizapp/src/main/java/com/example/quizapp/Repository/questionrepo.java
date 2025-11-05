package com.example.quizapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.quizapp.model.questions;

@Repository
public interface questionrepo extends JpaRepository<questions, Integer> {
    
    List<questions> findByCategory(String category);

    List<questions> findById(int id); 


    @Query(value = "SELECT * FROM questions q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<questions> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);

}
