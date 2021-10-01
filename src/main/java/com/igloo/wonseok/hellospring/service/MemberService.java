package com.igloo.wonseok.hellospring.service;

import com.igloo.wonseok.hellospring.domain.Member;
import com.igloo.wonseok.hellospring.repository.MemberRepository;
import com.igloo.wonseok.hellospring.repository.MemoryMemerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

 //Autowirde와 연결
public class MemberService {
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {
        //이름 중복x
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) { //ctrl + alt + m = 블록을 메소드로 따로 추출 ㄷㄷ
        memberRepository.findByNaMember(member.getName())
                .ifPresent(m -> { //result에 값이 있으면
                    try {
                        throw new IllegalAccessException("이미 존재하는 회원입니다");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
