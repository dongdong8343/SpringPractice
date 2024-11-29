package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 컨트롤러 객체를 만들어서 스프링 컨테이너에서 스프링 빈이 관리됨.
public class MemberController {
    private final MemberService memberService; // 하나만 생성해서 공용으로 사용하는게 좋음 -> 스프링 빈에 등록
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
