import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestApplication {

    // Currency currency = new Currency("Евро");
    //
    // @Test
    // public void testMysqlDriver() throws SQLException {
    //     Assert.assertEquals("com.mysql.cj.jdbc.Driver", DriverManager.getDriver("jdbc:mysql://localhost:3306/mysql").getClass().getName());
    // }
    //
    // @Test
    // public void testPostgresSingleConnection() {
    //     Connection connection_1 = ConnectionMysql.getInstance("jdbc:mysql://localhost:3306/mysql", "root", "root");
    //     Connection connection_2 = ConnectionMysql.getInstance("jdbc:mysql://localhost:3306/mysql", "root", "root");
    //     Assert.assertEquals(connection_1, connection_2);
    // }
    //
    // @Test
    // public void testInsertMysql() throws ClassNotFoundException {
    //     Assert.assertTrue(MysqlDB.insertCurrencyCourse(currency));
    // }

    @Test
    public void printHello() {
        System.out.println("HELLO");
    }
}
