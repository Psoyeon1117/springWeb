package springPractice1.hello_spring.repository;

import springPractice1.hello_spring.domain.Member;

import java.util.*;

//데이터 베이스에 접근. 도메인 객체를 DB에 저장하고 관리한다.

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();   //메모리 임시 저장소이다.
    private static long sequence = 0L;  //id

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);  //저장소에 데이터를 넣는다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values(

        ));
    }
    public void clearStore(){
        store.clear();
    }
}
