package springPractice1.hello_spring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import springPractice1.hello_spring.domain.Member;
import springPractice1.hello_spring.repository.MemberRepository;
import springPractice1.hello_spring.repository.MemoryMemberRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional  //DB에 test data를 commit하지 않는다. 즉, test가 끝난 후에 데이터가 남아있지 않는다.
public class MemberServiceIntegrationTest {
    //컨테이너와 DB까지 활용하는 테스트를 보통 통합테스트라고 한다.
    @Autowired MemberRepository repository;
    @Autowired MemberService memberService;

    @Test
    void 회원가입() {
        //given - 주어진 데이터에 대해서
        Member member = new Member();
        member.setName("spring");

        //when - 이러한 상황일 때
        Long saveId = memberService.join(member);

        //then - 어떻게 행동할 것인가
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원확인() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, ()->memberService.join(member2));

    }


}
