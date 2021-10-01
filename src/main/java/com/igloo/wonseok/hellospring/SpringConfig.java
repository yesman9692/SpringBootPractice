package com.igloo.wonseok.hellospring;

import com.igloo.wonseok.hellospring.repository.JdbcTemplateMemberRepository;
import com.igloo.wonseok.hellospring.repository.MemberRepository;
import com.igloo.wonseok.hellospring.repository.MemoryMemerRepository;
import com.igloo.wonseok.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemerRepository ();
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
