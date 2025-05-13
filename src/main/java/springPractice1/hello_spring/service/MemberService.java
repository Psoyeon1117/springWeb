package springPractice1.hello_spring.service;

import springPractice1.hello_spring.domain.Member;
import springPractice1.hello_spring.repository.MemberRepository;
import springPractice1.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//서비스에서는 핵심 비즈니스 로직들을 구현한다.
//서비스를 통해 다른계층에 접근함으로써 코드의 일관성을 유지하고 쳬계적이게 유지한다.

public class MemberService {
    private final MemberRepository repository = new MemoryMemberRepository();

    //회원가입
    public Long join(Member member){
        //중복 이름을 갖는 회원이 있어선 안된다.
        validateDuplicateMember(member);
        repository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 있는 이름입니다.");
                        });
    }
    //회원을 조회하는 함수
    public List<Member> findMembers(){
        return repository.findAll();
    }
    public Optional<Member> findOne(Long MemberId){
        return repository.findById(MemberId);
    }
}
