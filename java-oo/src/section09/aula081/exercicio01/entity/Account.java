package section09.aula081.exercicio01.entity;


public class Account {
    private int number;
    private String holder;
    private double balance;

    public Account(int number, String holder){
        this.number = number;
        this.holder = holder;
    }    

    public Account(int number, String holder, double value){
        this.number = number;
        this.holder = holder;  
        deposit(value);
    }

    public int getNumber(){
        return number;
    }

    public void setHolder(String name){
        holder = name;
    }

    public String getHolder(){
        return holder;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(Double value){
        balance += value;
    }

    public void withdraw(Double value){
        Double tax = 5.0;
        balance -= (value + tax);
    }

    public String toString(){
        return String.format("Account %d, Holder: %s, Balance: $ %.2f\n", 
            getNumber(), getHolder(), getBalance());
    }
}