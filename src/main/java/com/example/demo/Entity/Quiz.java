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
    @GeneratedValue // id는 자동생성되게
    private int Quizid;

    @JsonBackReference // 순환 참조 해결을 위해 추가
    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계 설정
    @JoinColumn(name = "userid") // 외래 키 지정
    private Member member;

    @Column(length = 2000)
    private String QuizQues;

    private String LectureName;

    private String QuizOption;


}
