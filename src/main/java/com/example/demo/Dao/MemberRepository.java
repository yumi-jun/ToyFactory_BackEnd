package com.example.demo.Dao;

import com.example.demo.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    boolean existsByUsernameAndPassword(String username,String password);

    boolean existsByUsername(String username);


    Optional<Member> findByUsername(String username);

    Optional<Member> findByUserlogin(String loginid);


    void deleteByUsername(String username);
}
