package section11;

import java.util.Date;

import util.Screen;

public class DateTimeRevision{

    
    public static void main(String...args){

        Screen.clear();
        testDate();
        // TODO: Revisar demais classes relacionadas com DATE/TIME.

    }

    @SuppressWarnings("deprecation")
    static void testDate(){
        // Cria um instante da forma classica.
        Date d1 = new Date();
        print(d1);

        // Cria uma data específica da forma clássica
        // deprecated, a maioria dos construtores estão depreciados nesse classe.
        // métodos também.
        Date d2 = new Date(2000, 1, 20);
        print(d2);

        // Construtor que aceita milisegundos em long.
        Date d3 = new Date(123234343);
        print(d3);

        // Converte Date para Instant, padrão ISO.
        print(d2.toInstant());

        print((new Date(2000, 1, 1)).getTime());
        print((new Date(2022, 12, 31)).getTime());

        // Retorma o objeto data representado por um long em milisegundos.
        print(d1.getTime());   
        Long t30 = (Long)(31536000000L * 31);   
        Long t52 = (Long)(31536000000L * 52);   
        print(t30);
        print(t52);
        print((new Date(t30)).toInstant());
        print((new Date(t52)).toInstant());
    }
// (1000 * 60 * 60 * 24 * 365 * 20)
    static void print(Object o){
        System.out.println(o);
    }
}