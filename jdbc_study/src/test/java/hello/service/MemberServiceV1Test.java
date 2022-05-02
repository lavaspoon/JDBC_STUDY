package hello.service;

import hello.repository.MemberRepositoryV1;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static hello.connection.ConnectionConst.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceV1Test {

    public static final String MEMBER_A = "memberA";
    public static final String MEMBER_B = "memberB";
    public static final String MEMBER_C = "memberC";

    private MemberRepositoryV1 memberRepositoryV1;
    private MemberServiceV1 memberServiceV1;

    @BeforeEach
    void before(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
    }
}