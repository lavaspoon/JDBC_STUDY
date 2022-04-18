package hello.repository;

import hello.connection.DBConnectionUtil;
import hello.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * JDBC - DriverManager 사용
 * Row Level - 0 테스트
 */
@Slf4j
public class MemberRepositoryV0 {
    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values(?, ?)";
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());

            pstmt.executeUpdate(); //영향받은 Row 숫자를 반환함(Int형)
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }
    //pstmt에서 exeption에 생기는 경우 con은 close 되지 않기때문에 따로 함수 생성
    //Statement, PreparedStatement 차이점은 쿼리 변수를 바인딩 할 수 있고 없고 차이(상속받음)
    private void close(Connection con, Statement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }

}

