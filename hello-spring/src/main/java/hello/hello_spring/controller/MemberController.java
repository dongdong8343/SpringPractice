package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller // 컨트롤러 객체를 만들어서 스프링 컨테이너에서 스프링 빈이 관리됨.
public class MemberController {
    private final MemberService memberService; // 하나만 생성해서 공용으로 사용하는게 좋음 -> 스프링 빈에 등록

    @Autowired // 생성자 주입을 권장한다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") // 데이터 등록할 때 post 사용
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/"; // post로 데이터를 받을 경우 리다이렉트로 작성해준다.
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}