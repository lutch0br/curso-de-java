package section14.aula156.entities;


public class Account {
    protected Integer number;
    protected String holder;
    protected Double balance;

    public Account(){

        System.out.println("Utilizar o construtor com args");
    }

    public Account(Integer number, String holder, Double balance){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber(){
        return number;
    }

    public String getHolder(){
        return holder;
    }

    public Double getBalance(){
        return balance;
    }

    public void withdraw(Double amount){
        double tax = 5.0;

        System.out.printf("Withdraw Account %d: %.2f + tax: %.2f...\n", 
            number, amount, tax);

        if ((balance - (amount + tax)) >= 0){
            balance -= amount + tax;
            System.out.printf("Success, Current Balance: %.2f\n", balance);
        } else {
            System.out.printf("Fail, Current Balance: %.2f\n", balance);
        }   
    }

    public void deposit(Double amount){
        System.out.printf("Deposit %.2f...\n", amount);
        this.balance += amount;
        System.out.println("Success");
    }

    @Override
    public String toString(){
        return String.format(
            "Number: %d, Holder: %s, Balance: %.2f", number, holder, balance
        );
    }
}