package hello.hello_spring;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 빈을 수동으로 등록하기 위함.
public class SpringConfig {
    @Bean // 스프링 컨테이너에 빈으로 등록함.
    public MemberService memberService(){
        return new MemberService(memberRepository()); // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}