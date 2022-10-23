package section08.aula072.exercicio01.app;

import java.util.Scanner;
import java.util.Locale;
import section08.aula072.exercicio01.util.CurrencyConverter;
import util.Screen;


public class Application {
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Screen.clear();
        CurrencyConverter.iof = 0.06;

        System.out.printf("Whats is the dollar price? ");
        CurrencyConverter.dollarPrice = sc.nextDouble();

        System.out.printf("How many dollars will be bought? ");
        CurrencyConverter.amountToBought = sc.nextDouble();

        showAmountToPay();

        sc.close();
    }

    static void showAmountToPay(){
        System.out.printf("Amount to be paid in reais = %.2f\n", 
            CurrencyConverter.amountToPay());
    }
}