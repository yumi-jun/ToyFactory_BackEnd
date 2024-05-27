package com.example.demo.Dao;
import com.example.demo.Entity.Quiz;
import com.example.demo.Entity.QuizExecutionCount;
import com.example.demo.Entity.QuizExecutionCountId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface QuizExecutionCountRepository extends JpaRepository<QuizExecutionCount, QuizExecutionCountId> {
    Optional<QuizExecutionCount> findByQuiz(Quiz quiz);
    List<QuizExecutionCount> findAllByOrderByExecutionCountDesc();
}
