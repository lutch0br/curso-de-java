package section18.aula229.app;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Instant;
import com.github.javafaker.Faker;

import section18.aula229.models.entities.Contract;
import section18.aula229.models.services.ContractService;
import section18.aula229.models.services.PaypalService;
import section18.aula229.models.entities.Installment;
import util.Screen;


/**
* Uma empresa deseja automatizar o processamento de seus contratos. O 
* processamento de um contrato consiste em gerar as parcelas a serem pagas para 
* aquele contrato, com base no número de meses desejado.
* A empresa utiliza um serviço de pagamento online para realizar o pagamento 
* das parcelas.
* Os serviços de pagamento online tipicamente cobram um juro mensal, bem como 
* uma taxa por pagamento. Por enquanto, o serviço contratado pela empresa é o 
* do Paypal, que aplica juros simples de 1% a cada parcela, mais uma taxa de
* pagamento de 2%.
* Fazer um programa para ler os dados de um contrato (número do contrato, data
* do contrato, e valor total do contrato). Em seguida, o programa deve ler o 
* número de meses para parcelamento do contrato, e daí gerar os registros de 
* parcelas a serem pagas (data e valor), sendo a primeira parcela a ser paga um 
* mês após a data do contrato, a segunda parcela dois meses após o contrato e
* assim por diante. Mostrar os dados das parcelas na tela.
*/
public class Program {

    static final Faker faker = new Faker();
    static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String...args) throws ParseException {
        Screen.clear();

        Contract contract = getContract();        
        int installments = faker.number().numberBetween(1, 10);

        System.out.println("Entre com os dados do contrato:");
        System.out.printf("Numero: %d\n", contract.getNumber());
        System.out.printf("Data (dd/MM/yyyy): %s\n", contract.getDate().format(dtf));
        System.out.printf("Valor do contrato: %.2f\n", contract.getTotalValue());
        System.out.printf("Quantidade de parcelas: %d\n", installments);

        ContractService service = new ContractService(new PaypalService(1.0, 2.0));
        service.processContract(contract, installments);

        System.out.println("Parcelas:");

        for(Installment installment: contract.getInstallments())
            System.out.printf("%s\n", installment);

        System.out.println();
    }

    static Contract getContract() throws ParseException{

        int number = faker.number().numberBetween(1000,9999);
        LocalDate date = dateToLocalDate(
                faker.date().between(sdf.parse("01/01/2018"), new Date()));
        double value = faker.number().randomDouble(2, 1000, 10000);
        
        return new Contract(number, date, value);
    }

    static LocalDate dateToLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}