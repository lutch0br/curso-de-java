package section18.aula229.models.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Contract {

    private Integer number;
    private LocalDate date;
    private Double totalValue;
    private List<Installment> installments = new ArrayList<>();

    public Contract (Integer number, LocalDate date, Double totalValue){
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getNumber(){
        return number;
    }

    public LocalDate getDate(){
        return date;
    }

    public void addInstallment(Installment installment){
        this.installments.add(installment);
    }

    public List<Installment> getInstallments(){
        return installments;
    }

    public Double getTotalValue(){
        return totalValue;
    }
}