package section15.aula177.account.app;


import section15.aula177.account.model.entities.Account;
import section15.aula177.account.model.exceptions.AmountExceedWithdrawException;
import section15.aula177.account.model.exceptions.NotEnoughBalanceException;
import util.Screen;

import java.util.Locale;
import com.github.javafaker.Faker;




public class Program {

    static final Faker faker = new Faker();

    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Screen.clear();

        try{
            System.out.printf("Enter account data\n");
            Account account = getAccount();
            double withdrawAmount = faker.number().randomDouble(2, 1000, 10000);

            System.out.println("");
            System.out.printf("Enter the ammount for withdraw: $ %.2f\n", 
                withdrawAmount);
            account.withdraw(withdrawAmount);
            System.out.printf("New balance: $ %.2f\n", account.getBalance());   

        } catch(AmountExceedWithdrawException e){
            System.out.printf("%s\n", e.getMessage());
        } catch(NotEnoughBalanceException e) {
            System.out.printf("%s\n", e.getMessage());
        } finally {
            System.out.println("");  
            System.out.println("Thank you!");
        }
        
    }

    static Account getAccount(){
        int number = faker.number().numberBetween(1000, 9999);
        String holder = faker.name().firstName();
        double balance = faker.number().randomDouble(2, 1000, 10000);
        double withdrawLimit = faker.number().randomDouble(2, 1000, 15000);

        System.out.printf("Number: %d\n", number);
        System.out.printf("Holder: %s\n", holder);
        System.out.printf("Initial balance: $ %.2f\n", balance);
        System.out.printf("Withdraw limit: $ %.2f\n", withdrawLimit);


        return new Account(number, holder, balance, withdrawLimit);
    }
}
