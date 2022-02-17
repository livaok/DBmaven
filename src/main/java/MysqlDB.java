import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDB{

    private MysqlDB() {
    }

    public static Connection getConnection() {
        return ConnectionMysql.getInstance( "jdbc:mysql://localhost:3306/mysql", "root", "root");
    }

    public static boolean insertCurrencyCourse(Currency currency) {

        boolean isSelect = false;

        try {
            Statement statement = getConnection().createStatement();
            String    createIfNotExist    = String.format("CREATE TABLE IF NOT EXISTS %s (Date date, Course decimal(10,4))", currency.getCurrency());
            String insertIfNotExist = String.format("INSERT INTO %s SELECT '%s', %.4f AS tmp WHERE NOT EXISTS (SELECT Date FROM %s WHERE Date = '%s')",
                currency.getCurrency(), currency.getDate(), currency.getCourse(), currency.getCurrency(), currency.getDate());
            String select = String.format("SELECT * FROM %s WHERE Date='%s'", currency.getCurrency(), currency.getDate());
            statement.execute(createIfNotExist);
            statement.execute(insertIfNotExist);
            isSelect = statement.execute(select);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return isSelect;
    }
}
