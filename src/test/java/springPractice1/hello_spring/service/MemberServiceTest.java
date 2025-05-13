package springPractice1.hello_spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import springPractice1.hello_spring.domain.Member;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemberServiceTest {
    MemberService memberService = new MemberService();
    @Test
    void 회원가입() {
        Member member = new Member();
        member.setName("soso");
        Long saveId = memberService.join(member);

        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원확인() {
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}