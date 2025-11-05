package com.example.quizapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizapp.model.quiz;

@Repository
public interface  quizrepository extends JpaRepository<quiz, Integer> {
    

}
