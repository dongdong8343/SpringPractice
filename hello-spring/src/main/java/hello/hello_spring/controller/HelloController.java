package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // /hello url로 접속하면 아래 메서드와 매핑됨.
    @GetMapping("hello")
    public String hello(Model model){
        // model에 key와 값을 추가함
        model.addAttribute("data", "hello");
        // viewResolver가 templates안에 있는 hello 파일을 찾아서 렌더링 함.
        return "hello";
    }

    @GetMapping("hello-mvc")
    // 데이터 받을 때 RequestParam으로 데이터 받을 수 있다.
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 응답 body부에 return 내용 넣어주겠다. => view 없음.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // JSON으로 반환하는게 기본임.
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        public String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
