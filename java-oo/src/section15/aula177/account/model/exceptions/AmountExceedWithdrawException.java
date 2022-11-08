package section15.aula177.account.model.exceptions;

public class AmountExceedWithdrawException extends RuntimeException {

    public AmountExceedWithdrawException(){
        super();
    }

    public AmountExceedWithdrawException(
        Double withdrawAmount, Double withdrawLimit){
        super(String.format(
            "Withdraw error: The withdraw amount $ %.2f, " 
            + "exceeds withdraw limit $ %.2f", 
            withdrawAmount, withdrawLimit
        ));
    }
}
