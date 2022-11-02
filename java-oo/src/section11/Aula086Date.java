    package section11;

import java.text.DateFormat;
import java.util.Locale;
import java.util.Date;
import java.util.Calendar;

import java.text.ParseException;

public class Aula086Date {
    public static void main(String...args) throws ParseException {
        // Criando uma data com Date 
        Date minhaData = new Date();

        // Todo objeto Date, quando impresso retorna o toString como texto
        System.out.printf("%s\n", minhaData);

        // Porém, ele retornará no Locale padrão da máquina.
        System.out.printf("%s\n", Locale.getDefault());

        // Caso deseje alterar essa saída, será necessário alterar o Locale
        // da máquina.        
        Locale.setDefault(Locale.US);
        System.out.printf("%s\n", Locale.getDefault());
        
        // DE OBJETO PARA TEXTO
        // Para utilizarmos Locale com a Data, utilizamos DateFormat
        // que recebe a data e retorna uma String.
        String hojeFormat = DateFormat.getInstance().format(minhaData);
        System.out.printf("%s\n", hojeFormat);
        
        Locale.setDefault(new Locale("pt", "BR"));

        String dataHoraFormatada = DateFormat.getInstance().format(new Date());
        System.out.printf("Data formatada: %s\n", dataHoraFormatada);

        String horaFormatada = DateFormat.getTimeInstance().format(new Date());
        System.out.printf("Data formatada: %s\n", horaFormatada);

        String dataHoraFormatoCurto = DateFormat.getTimeInstance(
            DateFormat.SHORT).format(new Date());

        System.out.printf("Data formato curto: %s\n", dataHoraFormatoCurto);
         
        // DE TEXTO PARA OBJETO

        String dataTexto = "12/02/2021 14:30";

        Date deTextoParaData = DateFormat.getInstance().parse(dataTexto);
        System.out.println(deTextoParaData);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        System.out.println(cal);
    }
}