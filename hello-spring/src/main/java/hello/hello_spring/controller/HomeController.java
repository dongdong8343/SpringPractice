package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") // 컨트롤러에서 먼저 "/"에 매핑되는 것이 있는지 찾는다.
    public String home(){
        return "home";
    }
}
