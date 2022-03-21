import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.time.LocalDate;

public class Currency {
    private final String currency;

    public Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency.replace(" ", "_");
    }

    public String getDate() {
        return LocalDate.now().toString();
    }

    public float getCourse() {
        float course = 0f;
        try {
            final URL        URL      = new URL("https://www.cbr.ru/currency_base/daily/");
            LineNumberReader reader   = new LineNumberReader(new InputStreamReader(URL.openStream()));
            String           nextLine = reader.readLine();

            while (nextLine != null) {
                if (nextLine.contains(currency)) {
                    course = Float.parseFloat(reader
                        .readLine()
                        .trim()
                        .replace("<td>", "")
                        .replace("</td>", "")
                        .replace(",", "."));
                    break;
                }
                else {
                    nextLine = reader.readLine();
                }
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return course;
    }
}
