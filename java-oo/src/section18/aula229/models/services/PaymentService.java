package section18.aula229.models.services;


public interface PaymentService {

    Double paymentFee(Double amount);

    Double interest(Double amount, Integer months);

}