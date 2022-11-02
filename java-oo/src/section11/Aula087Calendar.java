package section11;


import java.util.Calendar;


public class Aula087Calendar {
    public static void main(String...args){
        Calendar cal = Calendar.getInstance();

        // A impressão do calendar é complexa
        System.out.printf("%s\n", cal);
        System.out.printf("\n\n");
        // Para melhorar podemos utilizar os campos 
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

