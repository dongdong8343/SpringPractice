package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// 이 클래스에 @Repository 붙이면 안됨. 인터페이스는 인스턴스화 할 수 없기 때문이다.
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    // optional => null을 바로 반환하는게 아니라 optional로 감싸서 반환 (java 8에 들어가있는 기능)
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
