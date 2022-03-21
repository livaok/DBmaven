import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestApplication {

    Currency euro = new Currency("Евро");

    // @Test
    // public void testMysqlDriver() throws SQLException {
    //     Assert.assertEquals("com.mysql.cj.jdbc.Driver", DriverManager.getDriver("jdbc:mysql://192.168.96.3:3306/mysql").getClass().getName());
    // }
    //
    // @Test
    // public void testMysqlSingleConnection() {
    //     Connection connection_1 = MysqlConnection.getInstance("jdbc:mysql://192.168.96.3:3306/mysql", "root", "root");
    //     Connection connection_2 = MysqlConnection.getInstance("jdbc:mysql://192.168.96.3:3306/mysql", "root", "root");
    //     Assert.assertEquals(connection_1, connection_2);
    // }

    @Test
    public void testMysqlDBInsert() {
        Assert.assertTrue(MysqlDB.insertCurrencyCourse(euro));
    }
}
