package section11;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;



public class Aula094DifDatasJava8 {
    public static void main(String...args) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = new Date();
        Date d2 = df.parse("01/05/2018");
        System.out.printf("Data 1: %s\n", d1);
        System.out.printf("Data 2: %s\n", d2);

        long difDatas = Math.abs(d1.getTime() - d2.getTime());
        System.out.printf("Diferença entre datas (Milissegundos): %s\n", difDatas);

        long dif1 = TimeUnit.DAYS.convert(difDatas, TimeUnit.MILLISECONDS);
        System.out.printf("Diferença entre datas (Dias): %s\n", dif1);

        int dif2 = (int) (difDatas / (1000 * 60 * 60 * 24));
        System.out.printf("Diferença entre datas (Dias): %s\n", dif2);

        LocalDate d3 = LocalDate.now();
        LocalDate d4 = LocalDate.of(2022, 10, 1);

        Period dif3 = Period.between(d3, d4);
        int dias = dif3.getDays();
        int meses = dif3.getMonths();
        int anos = dif3.getYears();
        System.out.printf("Diferença entre datas (Dias): %s\n", dif3);
        System.out.printf("Diferença entre datas (dias): %s\n", dias);
        System.out.printf("Diferença entre datas (meses): %s\n", meses);
        System.out.printf("Diferença entre datas (anos): %s\n", anos);

        long difMeses = ChronoUnit.MONTHS.between(d3, d4);
        long difDias = ChronoUnit.DAYS.between(d3, d4);
        System.out.printf("Diferença entre datas (meses): %s\n", difMeses);
        System.out.printf("Diferença entre datas (dias): %s\n", difDias);
    }
}