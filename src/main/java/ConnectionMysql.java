import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {
    private static Connection ConnectionMysql;
    public          String     url;
    public          String     user;
    public          String     password;

    public ConnectionMysql(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public static Connection getInstance(String url, String user, String password) {
        if (ConnectionMysql == null) {
            try {
                ConnectionMysql = DriverManager.getConnection(url, user, password);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ConnectionMysql;
    }
}
