package section11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Aula091DateFormat {
    public static void main(String...args) throws ParseException {
        Date d01 = new Date();

        System.out.printf("%s\n", d01);

        String s01 = DateFormat.getInstance().format(d01);
        System.out.printf("%s\n", s01);

        Locale.setDefault(new Locale("en", "US"));

        String s02 = DateFormat.getInstance().format(d01);
        System.out.printf("%s\n", s02);

        String s03 = "02/11/2022 08:07";
        String s04 = "11/2/22, 8:29 AM";
        Date d02 = DateFormat.getInstance().parse(s04);

        System.out.printf("%s\n", d02);

    }
}