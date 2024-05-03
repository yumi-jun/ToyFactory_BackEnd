package com.example.demo.Controller;

import com.example.demo.Dao.MemberRepository;
import com.example.demo.Entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MemberController {

    private final MemberRepository repository;

    public MemberController(MemberRepository memberRepository) {
        this.repository = memberRepository;
    }

    @PostMapping("/members")
    public ResponseEntity<String> handleDataFromUnity(@RequestBody Member data) {
        // Unity로부터 받은 데이터를 활용하여 원하는 작업 수행
        // 예: 데이터베이스에 저장, 처리 후 결과 반환 등

        //1. 중복 아이디 체크
        Optional<Member> existingMember = repository.findByUserlogin(data.getUserlogin());

        // 중복 아이디 체크 됨~~
        if (existingMember.isPresent()) {
            // 중복된 아이디가 이미 존재하는 경우
            return ResponseEntity.ok("signup uploaded failed. Duplicate user login.");
        } else {
            // 중복된 아이디가 없는 경우

            // 회원 정보 저장
            repository.save(data);

            return ResponseEntity.ok("signup uploaded success.");
        }

    }

    @GetMapping("/members")
    public ResponseEntity<Member> LoginDataFromUnity(@RequestParam String userlogin, @RequestParam String password) {

        //1. login 에 대한 유저의 정보가 있었을 때
        Optional<Member> optionalMember = repository.findByUserlogin(userlogin);

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            if (member.getPassword().equals(password)) {
                // 비밀번호 일치
                return ResponseEntity.ok(member);
            } else {
                // 비밀번호 불일치
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            // 해당 사용자가 없음
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/members")
    public ResponseEntity<String>  RemoveMember(@RequestParam String name)
    {
        return ResponseEntity.notFound().build();

    }
}


