package section10.aula099.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import section10.aula099.entities.Funcionario;


public class Empresa {
    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static int registrar(Funcionario funcionario){
        if (idNaoCadastrado(funcionario.getId())){
            funcionarios.add(funcionario);
            return 1;
        }
        else {
            System.out.printf("Id já Cadastrado\n\n");
            return 0;
        }
    }

    public static void reajustarSalario(Integer id, Double percentual){
        Funcionario funcionario = funcionarios.stream()
            .filter(f -> f.getId() == id)
            .findFirst()
            .orElse(null);

        if (funcionario == null) {
            System.out.printf("ID não encontrado\n");
        } else {
            funcionario.reajustarSalario(percentual);       
            System.out.printf("Reajuste realizado com sucesso\n");
        }        
    }

    public static boolean idNaoCadastrado(Integer id){
        Funcionario funcionario = funcionarios.stream()
            .filter(f -> f.getId() == id)
            .findAny()
            .orElse(null);

        return funcionario == null;
    }

    public static void listarFuncionarios(){
        StringBuilder mensagem = new StringBuilder("Lista de Funcionários: \n");
        
        mensagem.append(String.format("%3s   %-8s %8s\n", "NRO", "NOME", "SALÁRIO"));

        for(Funcionario f : funcionarios){
            mensagem.append(f + "\n");
        }

        System.out.printf("%s", mensagem);
    }
}