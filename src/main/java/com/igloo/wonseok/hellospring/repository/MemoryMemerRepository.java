package com.igloo.wonseok.hellospring.repository;

import com.igloo.wonseok.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemerRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) { //고객의 id를 저장하는 기능
         member.setId(++sequence); //setter를 통해 member의 id를 셋팅함.
        store.put(member.getId(), member); //getter를 통해 저장한 id를 가져오고, Map형의 store변수에 저장.
        return member; //저장된 결과 반환
    }

    @Override
    public Optional<Member> findById(Long id) { //id로 찾는 기능.
        return Optional.ofNullable(store.get(id)); //null이 들어와도 optional로 감쌀 수 있음. (null pointer exception을 방지하기위함읹듯?)
    }

    @Override
    public Optional<Member> findByNaMember(String name) { //
        return store.values().stream() //store에서 저장된 값을 가져오는 함수인듯(?)
                .filter(member -> member.getName().equals(name)) //member의 name과 파라미터로 넘어온 name이 같은지 확인
                 .findAny(); //하나라도 찾으면! 반환됨. 없으면 optional에 null이 감싸져서 반환.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
