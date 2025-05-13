package springPractice1.hello_spring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import springPractice1.hello_spring.domain.Member;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//MemoryMemberRepository의 코드들을 테스트한다.
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  //메소드가 종료될때마다 매번 실행된다.
    public void afterEach(){
        repository.clearStore();    //저장소를 비운다.
    }

    @Test   //Test함수임을 명시한다.
    public void save(){
        Member member = new Member();
        member.setName("soyeon");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("syoen");
        repository.save(member2);

        Member result = repository.findByName("syoen").get();
        assertThat(member2).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("syoen");
        repository.save(member2);

        List<Member> results = repository.findAll();
        assertThat(results.size()).isEqualTo(2);
    }
}
