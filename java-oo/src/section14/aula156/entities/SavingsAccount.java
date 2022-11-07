package section14.aula156.entities;


public class SavingsAccount extends Account {

    private Double interestRate;

    public SavingsAccount(Integer number, String holder, Double balance, 
        Double interestRate){
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public void updateBalance(){
        balance += balance + interestRate;
    }

    @Override
    public void withdraw(Double amount){
        double tax = 0.0;

        System.out.printf("Withdraw SavingsAccount %d: %.2f + tax: %.2f...\n", 
            number, amount, tax);

        if ((balance - (amount + tax)) >= 0){
            balance -= amount + tax;
            System.out.printf("Success, Current Balance: %.2f\n", balance);
        } else {
            System.out.printf("Fail, Current Balance: %.2f\n", balance);
        }  
    }

    @Override
    public String toString(){
        return String.format(
            "%s, Interest Rate: %.2f", super.toString(), interestRate
        );
    }
}
