package hello.hello_spring.domain;

import jakarta.persistence.*;

@Entity // jpa를 사용하기 위해서 엔티티라고 알려줘야 함.
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 시스템이 정하는 id
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
