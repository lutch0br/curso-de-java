package section14.aula156.entities;


public class BusinessAccount extends Account{
    private Double loanLimit;

    public BusinessAccount(){
        super();
    }

    public BusinessAccount(Integer number, String holder, Double balance,
        Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public void withdraw(Double amount){
        double tax = 10.0;

        System.out.printf(
            "Withdraw BusinessAccount %d: %.2f + tax: %.2f...\n", 
            number, amount, tax);

        if ((balance - (amount + tax)) >= 0){
            balance -= amount + tax;
            System.out.printf("Success, Current Balance: %.2f\n", balance);
        } else {
            System.out.printf("Fail, Current Balance: %.2f\n", balance);
        }          
    }

    public void loan(Double amount){
        System.out.printf("Loan %.2f...\n", amount);
        if (balance <= loanLimit) {
            balance += amount - 10;
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
    }

    @Override
    public String toString(){
        return String.format(
            "%s, Loan Limite: %.2f", super.toString(), loanLimit);
    }
}