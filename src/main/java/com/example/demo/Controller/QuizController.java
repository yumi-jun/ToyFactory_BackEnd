package com.example.demo.Controller;

import com.example.demo.Dao.MemberRepository;
import com.example.demo.Dao.QuizRepository;
import com.example.demo.Entity.Member;
import com.example.demo.Entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private QuizRepository quizRepository;


    @PostMapping("/quiz")
    public ResponseEntity<String> uploadQuiz(@RequestParam String quizQues,@RequestParam String lectureName,  @RequestParam String id) {

        System.out.println("----1");
        // id를 int로 변환하여 사용할 수 있습니다.
        int userId = Integer.parseInt(id);

       Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")
                );
       
        // 회원 정보와 퀴즈 내용을 사용하여 Quiz 엔티티 생성
        // user 과 퀴즈는 일대 다 관계

        if(member!=null) {
            Quiz quiz = new Quiz();
            quiz.setMember(member); // 회원 정보 설정
            quiz.setQuizQues(quizQues); // 퀴즈 내용 설정
            quiz.setLectureName(lectureName); // 퀴즈 이름 설정

            // 생성된 퀴즈 엔티티를 저장합니다.
            quizRepository.save(quiz);

            return ResponseEntity.ok("Quiz uploaded success.");
        }
        else{
            return ResponseEntity.ok("Quiz uploaded failed.");
        }
    }

    @GetMapping("quiz/{userId}")
    public ResponseEntity<List<Quiz>> getQuizzesByUserId(@PathVariable("userId") int userId) {

        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 해당 사용자가 올린 퀴즈 조회
        List<Quiz> quizzes = quizRepository.findByMember(member);
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/quiz")
    public ResponseEntity<List<Quiz>> GetQuizList()
    {
        List<Quiz> quizzes = quizRepository.findAll();

        return ResponseEntity.ok(quizzes);
    }


}
