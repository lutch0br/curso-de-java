package section11;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.ZoneId;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class Application {
    public static void main(String...args) throws ParseException{

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        System.out.printf("d01: %s\n", d01);
        System.out.printf("d02: %s\n", d02);
        System.out.printf("d03: %s\n", d03);

        LocalDate d04 = LocalDate.parse("2022-02-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-02-20T01:30:23");
        Instant d06 = Instant.parse("2022-02-20T01:20:23Z");

        System.out.printf("d04: %s\n", d04);
        System.out.printf("d05: %s\n", d05);
        System.out.printf("d06: %s\n", d06);

        DateTimeFormatter dtf01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf02 = 
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDate d07 = LocalDate.parse("22/10/2020", dtf01);
        LocalDateTime d08 = LocalDateTime.parse("22/10/2020 01:22:00", dtf02);

        System.out.printf("d07: %s\n", d07);
        System.out.printf("d08: %s\n", d08);

        LocalDate d09 = LocalDate.of(2022, 10, 01);
        LocalDateTime d10 = LocalDateTime.of(2022, 10, 01, 13, 31, 45);

        System.out.printf("d09: %s\n", d09);
        System.out.printf("d10: %s\n", d10);

        System.out.printf("%s\n", LocalDate.parse("2022-02-20").format(dtf01));

        DateTimeFormatter dtf03 = DateTimeFormatter
            .ofPattern("dd/MM/yyyy HH:mm")
            .withZone(ZoneId.systemDefault());
        System.out.printf("%s\n", dtf03.format(d06));

        LocalDateTime d11 = LocalDateTime
            .ofInstant(d06, ZoneId.of("America/Sao_Paulo"));
        System.out.printf("%s\n", d11);

        System.out.printf("%d\n", d11.getDayOfMonth());

        System.out.printf("%s\n", d11.minusDays(10));
        System.out.printf("%s\n", d11.plusDays(2));

        System.out.printf("%s\n", d06.minus(7, ChronoUnit.DAYS));

        Duration d1 = Duration.between(d11.minusDays(10), d11.plusDays(2));
        System.out.printf("%d\n", d1.toDays());

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date d12 = sdf1.parse("24/02/2022");

        System.out.printf("%s\n", d12);
        System.out.printf("%s\n", sdf1.format(d12));

        Date d13 = new Date();
        System.out.printf("%s\n", d13);

        Date d14 = new Date(13131313131313L);
        System.out.printf("%s\n", d14);

        Date d15 = Date.from(d06);
        System.out.printf("%s\n", sdf1.format(d15));

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date d16 = Date.from(d06);
        System.out.printf("%s\n", sdf2.format(d16));

        Calendar cal = Calendar.getInstance();
        cal.setTime(d15);
        cal.add(Calendar.HOUR_OF_DAY, 5);

        System.out.printf("%s\n", cal.getTime());

        int minutes = cal.get(Calendar.MINUTE);
        System.out.printf("%d\n", minutes);

        int months = cal.get(Calendar.MONTH);
        System.out.printf("%d\n", months);


    }
}

