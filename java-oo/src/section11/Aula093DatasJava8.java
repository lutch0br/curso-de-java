package section11;


import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class Aula093DatasJava8 {

    public static void main(String...args){

        // Instanciação
        LocalDate d01 = LocalDate.now();
        System.out.printf("Criação de data-agora: %s\n", d01);

        LocalDate d02 = LocalDate.of(2019, 3, 12);
        System.out.printf("Criação de data-definida: %s\n", d02);

        LocalDate d03 = LocalDate.parse("2019-03-12");
        System.out.printf("Criação de data da String: %s\n", d03);

        // Operações 
        System.out.printf("Adição de 3 dias na data anterior: %s\n", d03.plusDays(3));
        System.out.printf("Subtração de 10 dias na data anterior: %s\n", d03.minusDays(10));

        // Integrando Date/LocalDate
        Date agora = new Date();
        ZoneId br = ZoneId.of("Africa/Cairo");
        LocalDateTime d04 = LocalDateTime.ofInstant(agora.toInstant(), br);
        System.out.printf("Conversão de Date para LocalDate: %s\n", d04);

    }
}