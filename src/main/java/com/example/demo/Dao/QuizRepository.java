package com.example.demo.Dao;

import com.example.demo.Entity.Member;
import com.example.demo.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizRepository  extends JpaRepository<Quiz, Integer> {
    List<Quiz> findByMember(Member member);

}
