package springPractice1.hello_spring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springPractice1.hello_spring.domain.Member;
import springPractice1.hello_spring.repository.MemberRepository;
import springPractice1.hello_spring.repository.MemoryMemberRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
    MemoryMemberRepository repository;
    MemberService memberService;
    @BeforeEach
    public void BeforeEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach  //메소드가 종료될때마다 매번 실행된다.
    public void afterEach(){
        repository.clearStore();    //저장소를 비운다.
    }

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

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}