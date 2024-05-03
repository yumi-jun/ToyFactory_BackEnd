package com.example.demo.Service;


import com.example.demo.Dao.MemberRepository;
import com.example.demo.Entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


public class MemberServcie {


    private MemberRepository memberRepository;

    // 중복 확인을 위한 isUserNameExits
    public boolean isUserNameExists(String userName)
    {
        return memberRepository.findByUsername(userName)!=null;
    }

    // database 에 멤버 저장
    public Member SaveMember(Member member)
    {
        return memberRepository.save(member);
    }

    // delete
    public void deleteMember(String username)
    {
        memberRepository.deleteByUsername(username);
    }


    
}
