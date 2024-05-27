package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Objects;

public class QuizExecutionCountId implements Serializable {

    private String userId;
    private int quizId;

    // Default constructor
    public QuizExecutionCountId() {
    }

    // Parameterized constructor
    public QuizExecutionCountId(String userId, int quizId) {
        this.userId = userId;
        this.quizId = quizId;
    }

    // Getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    // Override equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizExecutionCountId that = (QuizExecutionCountId) o;
        return quizId == that.quizId &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, quizId);
    }
}