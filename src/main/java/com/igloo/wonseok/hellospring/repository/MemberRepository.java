package com.igloo.wonseok.hellospring.repository;

import com.igloo.wonseok.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //고객의 id를 저장하는 기능
    Optional<Member> findById(Long id); //id로 찾는 기능.
    Optional<Member> findByNaMember(String name); //name으로 찾는 기능
    List<Member> findAll(); //
}
