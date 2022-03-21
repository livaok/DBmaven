import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private static Connection mysqlConnection;
    public         String     url;
    public         String     user;
    public         String     password;

    public MysqlConnection(String url, String user, String password) {
        this.url      = url;
        this.user     = user;
        this.password = password;
    }

    public static Connection getInstance(String url, String user, String password) {
        if (mysqlConnection == null) {
            try {
                mysqlConnection = DriverManager.getConnection(url, user, password);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mysqlConnection;
    }
}
