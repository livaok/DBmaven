
public class Application {
    public static void main(String[] args) {
        Currency euro   = new Currency("Евро");
        Currency dollar = new Currency("Доллар");

        MysqlDB.insertCurrencyCourse(euro);
        MysqlDB.insertCurrencyCourse(dollar);
    }
}
