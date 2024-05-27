package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data //Lombok 에서 제공해주는 getter 과 setter 임.
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // 필드 이름을 quizid로 변경
    @JsonBackReference // 순환 참조 해결을 위해 추가
    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계 설정
    @JoinColumn(name = "userid") // 외래 키 지정
    private Member member;

    @Column(length = 2660)
    private String QuizQues;

    private String LectureName;

    private String QuizOption;

    private int executionCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getQuizQues() {
        return QuizQues;
    }

    public void setQuizQues(String quizQues) {
        QuizQues = quizQues;
    }

    public String getLectureName() {
        return LectureName;
    }

    public void setLectureName(String lectureName) {
        LectureName = lectureName;
    }

    public String getQuizOption() {
        return QuizOption;
    }

    public void setQuizOption(String quizOption) {
        QuizOption = quizOption;
    }

    public int getExecutionCount() {
        return executionCount;
    }

    public void setExecutionCount(int executionCount) {
        this.executionCount = executionCount;
    }

    // Getters and setters
    public void incrementExecutionCount() {
        this.executionCount++;
    }

}
