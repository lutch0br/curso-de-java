package section15.aula177.account.model.exceptions;

public class NotEnoughBalanceException extends RuntimeException {

    public NotEnoughBalanceException(){
        super();
    }

    public NotEnoughBalanceException(
        Double balance, Double withdrawAmount){
        super(String.format(
            "Withdraw error: Balance $ %.2f not enough to withdraw $ %.2f", 
            balance, withdrawAmount
        ));
    }
}