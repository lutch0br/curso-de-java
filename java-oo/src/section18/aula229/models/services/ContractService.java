package section18.aula229.models.services;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

import section18.aula229.models.entities.Contract;
import section18.aula229.models.entities.Installment;


public class ContractService {

    private PaymentService paymentService;

    public ContractService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months){         
        double installmentValueInitial = (double)contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++){
            double interest = paymentService.interest(installmentValueInitial, i);
            double fee = paymentService.paymentFee(installmentValueInitial + interest) ;
            double installmentValueTotal = installmentValueInitial + interest + fee;
            LocalDate installmentDate = contract.getDate().plusMonths(i);
            
            contract.addInstallment(new Installment(installmentDate, installmentValueTotal));
        }
    }
}
