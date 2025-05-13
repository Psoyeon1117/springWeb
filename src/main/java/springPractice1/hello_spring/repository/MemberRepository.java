package springPractice1.hello_spring.repository;

import springPractice1.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

//DB가 정해지지 않았을 경우, 먼저 인터페이스를 구현함으로써
//이후에 구현 클래스를 쉽게 변경가능하게 한다.
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
