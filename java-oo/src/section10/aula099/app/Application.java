package section10.aula099.app;

import java.util.Scanner;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import section10.aula099.entities.Funcionario;
import section10.aula099.util.Empresa;
import util.Screen;


public class Application {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String...args){
        Locale.setDefault(Locale.US);

        Screen.clear();

        System.out.print("Quantos funcionários serão registrados?: ");
        int n = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < n;){ 
            System.out.printf("Funcionário %d:\n", i + 1);

            System.out.print("Id: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Salário: ");
            Double salario = Double.parseDouble(sc.nextLine());

            i += Empresa.registrar(new Funcionario(id, nome, salario));
            System.out.println();
        }

        System.out.printf("Entre com o id do funcionario para reajustar salário: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.printf("Entre com o percentual para reajustar salário: ");
        double percentual = Double.parseDouble(sc.nextLine());
        Empresa.reajustarSalario(id, percentual);
        
        System.out.println();
        Empresa.listarFuncionarios();

        System.out.println();
        sc.close();
    }


}