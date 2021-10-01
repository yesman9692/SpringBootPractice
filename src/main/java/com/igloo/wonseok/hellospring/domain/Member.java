package com.igloo.wonseok.hellospring.domain;

public class Member { //고객 정보를 담는 객체

    private Long id; //시스템이 정해주는 id값
    private String name; //고객이 가입할때 입력하는 id(name)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
