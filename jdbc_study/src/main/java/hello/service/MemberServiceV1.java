package hello.service;

import hello.domain.Member;
import hello.repository.MemberRepositoryV0;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class MemberServiceV1 {

    private final MemberRepositoryV0 memberRepositoryV0;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepositoryV0.findById(fromId);
        Member toMember = memberRepositoryV0.findById(toId);

        memberRepositoryV0.update(fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepositoryV0.update(toId, toMember.getMoney() + money);


    }

    private void validation(Member toMember) {
        if(toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
