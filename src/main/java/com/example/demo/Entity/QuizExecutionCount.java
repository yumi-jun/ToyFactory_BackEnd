package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class QuizExecutionCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int executionId;

    @ManyToOne
    @JoinColumn(name = "quizid", foreignKey = @ForeignKey(name = "fk_quiz"))
    private Quiz quiz;

    private int executionCount;

    // Getters and setters
    public int getExecutionId() {
        return executionId;
    }

    public void setExecutionId(int executionId) {
        this.executionId = executionId;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public int getExecutionCount() {
        return executionCount;
    }

    public void setExecutionCount(int executionCount) {
        this.executionCount = executionCount;
    }
}
