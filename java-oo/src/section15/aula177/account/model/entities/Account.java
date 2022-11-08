package section15.aula177.account.model.entities;


import section15.aula177.account.model.exceptions.AmountExceedWithdrawException;
import section15.aula177.account.model.exceptions.NotEnoughBalanceException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){}

    public Account(Integer number, String holder, Double balance,
        Double withdrawLimit){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
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

    public void withdraw(Double withdrawAmount){
        if (withdrawAmount > withdrawLimit){
            throw new AmountExceedWithdrawException(withdrawAmount, withdrawLimit);
        }
        if (withdrawAmount > balance) {
            throw new NotEnoughBalanceException(balance, withdrawAmount);
        } 
        
        balance -= withdrawAmount;        
    }

    public void deposit(Double amount){        
        this.balance += amount;        
    }

    @Override
    public String toString(){
        return String.format(
            "Number: %d, Holder: %s, Balance: $ %.2f, Withdraw Limit: $ %.2f", 
            number, holder, balance, withdrawLimit
        );
    }
}