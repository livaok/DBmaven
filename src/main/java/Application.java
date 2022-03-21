import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        System.out.println("START...................................");
        Class.forName("com.mysql.jdbc.Driver");
        // Currency euro   = new Currency("Евро");
        // Currency dollar = new Currency("Доллар");

        // MysqlDB.insertCurrencyCourse(euro);
        // MysqlDB.insertCurrencyCourse(dollar);

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.96.3:3306/mysql",
            "root", "root");
        System.out.println(connection);

        System.out.println("END.....................................");
    }
}
