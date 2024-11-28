package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService { // 비즈니스에 가까운 용어로 쓰기(비즈니스에 의존적)
    private final MemberRepository memberRepository = new MemoryMemberRepository();
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
                    throw new IllegalArgumentException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}