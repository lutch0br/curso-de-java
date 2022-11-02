package section11;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


public class Aula089SimpleDateFormat{
    public static void main(String...args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        System.out.printf("Imprimindo um calendar: %s\n", cal);
        System.out.printf("Imprimindo um cal.getTime: %s\n", cal.getTime());
        System.out.printf("Imprimindo um cal.getTime formatado: %s\n", 
            sdf.format(cal.getTime()));

        String s01 = "20/01/2002 13:01:00";
        Date d01 = sdf.parse(s01);
        String s02 = sdf.format(d01);

        System.out.printf("Imprimindo um Date formatado gerado com o parse: %s\n", 
            s02);

    }
}