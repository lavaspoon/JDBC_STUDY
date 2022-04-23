package hello.connection;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.connection.ConnectionConst.*;

/**
 * DriverManager
 * -> 커넥션 정보를 가져올때마다 URL, USERNAME, PASSWORD 정보를 넘겨야함
 * DataSource
 * -> 처음 객체를 생성할 때만 필요한 파라미터를 넘겨두고, 커넥션을 획득할 때는 단순히 getConnection 호출
 */
public class ConnectionTest {
    @Test
    void driverManger() throws SQLException {
        //DriverManger 인터페이스를 이용해서 커넥션 정보를 가져오는 방법
        Connection con1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Connection con2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("connection= " + con1 + " class=" + con1.getClass());
        System.out.println("connection= " + con2 + " class=" + con2.getClass());
    }

    @Test
    void dataSourceDriverManger() throws SQLException {
        //DataSource 인터페이스를 이용해서 커넥션 정보를 가져오는 방법
        //DriverMangerDataSource - 항상 새로운 커넥션을 획득
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        useDataSrouce(dataSource);
    }

    private void useDataSrouce(DataSource dataSource) throws SQLException {
        Connection con1 = dataSource.getConnection();
        Connection con2 = dataSource.getConnection();
        System.out.println("connection= " + con1 + " class=" + con1.getClass());
        System.out.println("connection= " + con2 + " class=" + con2.getClass());
    }
}
