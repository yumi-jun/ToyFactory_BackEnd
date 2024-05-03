package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data //Lombok 에서 제공해주는 getter 과 setter 임.
@Entity
public class Member {

    @Id
    @GeneratedValue // id는 자동생성되게
    private int id;

    private String userlogin;

    private String username;
    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL) // 일대다 관계 설정
    private List<Quiz> quizzes;

}
