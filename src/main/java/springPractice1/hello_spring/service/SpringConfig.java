package springPractice1.hello_spring.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springPractice1.hello_spring.repository.MemberRepository;
import springPractice1.hello_spring.repository.MemoryMemberRepository;

//자바코드로 직접 스프링 빈을 등록한다.
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
