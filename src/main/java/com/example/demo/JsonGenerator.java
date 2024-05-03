package com.example.demo;


import com.example.demo.Entity.Member;
import com.google.gson.Gson;

public class JsonGenerator {

    public static void main(String[] args) {
        Member m = new Member();
        m.setUsername("sdf");
       m.setPassword("asdf");

        Gson gson=new Gson();
        String json=gson.toJson(m);

        System.out.println(json);

    }
}
