package section18.aula229.models.entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Installment {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dueDate;
    private Double amount;

    public Installment(LocalDate dueDate, Double amount){
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public double getAmount(){
        return amount;
    }

    public String toString(){
        return String.format("%s - %.2f", getDueDate().format(dtf), getAmount());
    }
}