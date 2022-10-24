package section09.aula081.exercicio01.app;

import java.util.Scanner;
import java.util.Locale;
import section09.aula081.exercicio01.entity.Account;
import util.Screen;


public class Application {
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account account;
        double value = 0;

        Screen.clear();
        System.out.print("Enter account number: ");
        int number = Integer.parseInt(sc.nextLine());

        System.out.print("Enter account holder: ");
        String name = sc.nextLine();

        System.out.print("Is there initial deposit? (y/n): ");
        char deposit = sc.next().charAt(0);

        if (deposit == 'y'){
            System.out.print("Enter initial deposit value: ");
            value = sc.nextDouble();
        }
        
        account = new Account(number, name, value);

        System.out.println();
        System.out.println("Account Data: ");
        System.out.print(account);

        System.out.println();
        System.out.print("Enter a deposit value: ");
        value = sc.nextDouble();
        account.deposit(value);
        System.out.println("Updated account data: ");
        System.out.print(account);

        System.out.println();
        System.out.print("Enter a withdraw value: ");
        value = sc.nextDouble();
        account.withdraw(value);
        System.out.println("Updated account data: ");
        System.out.print(account);

        sc.close();
    }
}
