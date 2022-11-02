package section11;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Aula088GregorianCalendar{
    public static void main(String...args){

        Calendar cal = new GregorianCalendar();
        imprimirDatas(cal);

    }

    static void imprimirDatas(Calendar cal){
        System.out.printf("DAY OF MONTH: %d\n", Calendar.DAY_OF_MONTH);
        System.out.printf("MONTH: %d\n", Calendar.MONTH);
        System.out.printf("YEAR: %d\n", Calendar.YEAR);
        System.out.println();
        System.out.printf("DAY OF MONTH: %02d\n", cal.get(Calendar.DAY_OF_MONTH));
        System.out.printf("MONTH: %02d\n", cal.get(Calendar.MONTH));
        System.out.printf("DAY OF MONTH: %d\n", cal.get(Calendar.YEAR));

        cal.set(2000, 12, 01);
        System.out.println();
        System.out.printf("DAY OF MONTH: %02d\n", cal.get(Calendar.DAY_OF_MONTH));
        System.out.printf("MONTH: %02d\n", cal.get(Calendar.MONTH));
        System.out.printf("DAY OF MONTH: %d\n", cal.get(Calendar.YEAR));        
    }
}