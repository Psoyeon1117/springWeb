package springPractice1.hello_spring.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springPractice1.hello_spring.repository.JdbcMemberRepository;
import springPractice1.hello_spring.repository.JdbcTemplateMemberRepository;
import springPractice1.hello_spring.repository.MemberRepository;
import springPractice1.hello_spring.repository.MemoryMemberRepository;

import javax.sql.DataSource;

//자바코드로 직접 스프링 빈을 등록한다.
@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
