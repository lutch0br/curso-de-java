package section11;


import java.util.Calendar;
import java.util.TimeZone;


public class Aula092TimeZone {
    public static void main(String...args){

        Calendar c = Calendar.getInstance();
        TimeZone tz = c.getTimeZone();

        System.out.printf("%s\n", tz);

        for (String fz : tz.getAvailableIDs())
            System.out.printf("%s\n", fz);

    }
}