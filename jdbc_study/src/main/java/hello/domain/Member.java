package hello.domain;

import lombok.Data;

@Data
public class Member {
    private String member;
    private int money;

    public Member() {
    }

    public Member(String member, int money) {
        this.member = member;
        this.money = money;
    }
}
