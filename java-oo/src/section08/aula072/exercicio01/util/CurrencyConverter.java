package section08.aula072.exercicio01.util;


public class CurrencyConverter {

    public static double dollarPrice;
    public static double iof;
    public static double amountToBought;

    public static double amountToPay(){
        return (amountToBought * dollarPrice) * (1 + iof);
    }
}