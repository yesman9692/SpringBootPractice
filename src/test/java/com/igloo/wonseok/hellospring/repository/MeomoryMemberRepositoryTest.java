package com.igloo.wonseok.hellospring.repository;

import com.igloo.wonseok.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MeomoryMemberRepositoryTest {

    MemoryMemerRepository repository = new MemoryMemerRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member find1 = repository.findByNaMember("spring1").get();
        String result1 = member1.getName();

        assertThat(find1).isEqualTo(member1);
    }
}
