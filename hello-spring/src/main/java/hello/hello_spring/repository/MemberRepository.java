package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    // optional => null을 바로 반환하는게 아니라 optional로 감싸서 반환 (java 8에 들어가있는 기능)
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
