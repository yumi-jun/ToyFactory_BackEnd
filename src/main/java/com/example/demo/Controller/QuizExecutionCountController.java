package com.example.demo.Controller;
import com.example.demo.Dao.QuizExecutionCountRepository;
import com.example.demo.Dao.QuizRepository;
import com.example.demo.Entity.Quiz;
import com.example.demo.Entity.QuizExecutionCount;
import com.example.demo.Entity.QuizExecutionCountId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz-execution")
public class QuizExecutionCountController {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizExecutionCountRepository quizExecutionRepository;


    @PostMapping("/{quizId}/increment")
    public ResponseEntity<?> incrementQuizExecutionCount(@PathVariable int quizId) {

        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.incrementExecutionCount();
        quizRepository.save(quiz);


        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/ranking")
    public ResponseEntity<List<Quiz>> getQuizRanking() {
        List<Quiz> quizzes= quizRepository.findByOrderByExecutionCountDesc();
        return  ResponseEntity.ok(quizzes);
    }

}
