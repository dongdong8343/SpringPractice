package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository를 상속받으면 자동으로 구현체를 빈에 등록해줌.
// JpaRepository에 공통적인 CRUD, PK로 찾는 것 등은 다 있어서 제공해줌.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
