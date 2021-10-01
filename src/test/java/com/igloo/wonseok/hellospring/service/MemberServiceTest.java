package com.igloo.wonseok.hellospring.service;

import com.igloo.wonseok.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {


    private final MemberService memberService;

    @Test
    void join() {
        //given : 이 상황이
        Member member = new Member();
        member.setName("hello");

        //when : 언제 주어졌을 때
        Long saveId = memberService.join(member);

        //then : 이런 결과가 나와야 해
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member1.setName("spring");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}