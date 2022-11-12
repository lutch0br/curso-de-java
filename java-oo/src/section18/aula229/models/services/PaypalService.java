package section18.aula229.models.services;


public class PaypalService implements PaymentService {

    private Double interest;
    private Double fee;

    public PaypalService(Double interest, Double fee){
        this.interest = interest;
        this.fee = fee;
    }

    public Double paymentFee(Double amount){
        return amount * (fee / 100);
    }

    public Double interest(Double amount, Integer months){
        return amount * (interest / 100) * months;
    }
}