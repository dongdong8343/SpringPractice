package hello.hello_spring.controller;
// 폼에서 전송한 데이터 받기 위한 클래스
// -> swagger을 통해 api 문서를 만들 때 Json에 어떤 값이 들어가야할지 명확하게 보여줘서 이 방식을 사용해야겠다.
public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
