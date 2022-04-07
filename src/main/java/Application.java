
public class Application {
    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println("START...................................");
        Class.forName("com.mysql.cj.jdbc.Driver");

        Currency euro   = new Currency("Евро");
        System.out.printf("Курс валюты %s на %s составляет %s%n", euro.getCurrency(), euro.getDate(), euro.getCourse());
        // Currency dollar = new Currency("Доллар");
        //
        // MysqlDB.insertCurrencyCourse(euro);
        // MysqlDB.insertCurrencyCourse(dollar);

        System.out.println("END.....................................");
        //у цб есть api, получить json
    }
}
