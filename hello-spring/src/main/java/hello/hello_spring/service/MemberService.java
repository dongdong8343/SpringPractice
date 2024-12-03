package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Transactional // jpa는 트랜잭션 안에서 실행돼야하기 때문이다.
public class MemberService { // 비즈니스에 가까운 용어로 쓰기(비즈니스에 의존적)
    private final MemberRepository memberRepository;
    // DI -> 매번 새롭게 repository를 만들면 서로 다른 저장소를 사용하게 되므로 하나만 만들어서 사용하는 것이 맞다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // 회원 가입
    public Long join(Member member){
        // 중복 회원 검증
        validateDulplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDulplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
