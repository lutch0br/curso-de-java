package section14.aula156.app;


import java.util.Locale;
import section14.aula156.entities.BusinessAccount;
import section14.aula156.entities.SavingsAccount;
import section14.aula156.entities.Account;
import util.Screen;


public class Program {
    public static void main(String...args){
        Locale.setDefault(Locale.US);

        Account a1 = new Account(1, "Mary", 1000.0);
        Account a2 = new BusinessAccount(2, "Peter", 1000.0, 500.0);
        Account a3 = new SavingsAccount(3, "Susan", 1000.0, 5.0);

        Screen.clear();
        System.out.printf("%s\n", a1);
        System.out.printf("%s\n", a2);
        System.out.printf("%s\n", a3);  
        System.out.println();      

        a1.withdraw(100.0);
        a2.withdraw(100.0);
        a3.withdraw(100.0);
        System.out.println();

        System.out.printf("%s\n", a1);
        System.out.printf("%s\n", a2);
        System.out.printf("%s\n", a3); 
        System.out.println();

    }
}