package com.example.demo;

import com.example.demo.Entity.Member;

public interface IMemberManager {
    boolean addPerson(Member p);
    Member getRandomPerson();
}
