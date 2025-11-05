package com.example.quizservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizservice.model.quiz;

@Repository
public interface  quizrepository extends JpaRepository<quiz, Integer> {
    

}
