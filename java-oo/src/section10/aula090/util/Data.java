package section10.aula090.util;

import java.util.Arrays;
import section10.aula090.entities.Pessoa;

public class Data{

    static Pessoa[] pessoas = new Pessoa[5];
    private static int quantidade;

    public static void adicionaPessoa(Pessoa pessoa){
        if (quantidade >= pessoas.length){
            int new_length = quantidade * 2;
            pessoas = Arrays.copyOf(pessoas, new_length);
        }

        pessoas[quantidade] = pessoa;
        quantidade++;
    }

    public static int quantidade(){
        return quantidade;
    }

    public static double alturaMedia(){
        double media = 0.0;
        for (int i = 0; i < quantidade; i++)
            media += pessoas[i].getAltura() / quantidade;
        
        return media;
    }

    public static void pessoas(){
        for (int i = 0; i < quantidade; i++)
            System.out.printf("%s\n", pessoas[i]);
    }

    public static int quantidadeMenoresQue16(){
        int quantidadeMenoresQue16 = 0;

        for (int i = 0; i < quantidade; i++){
            if (pessoas[i].getIdade() < 16)
                quantidadeMenoresQue16++;
        }  

        return quantidadeMenoresQue16;
    }

    public static double percentualMenoresQue16(){
        return (double) quantidadeMenoresQue16() / quantidade() * 100;

    }

    public static String pessoasMenoresQue16(){
        StringBuilder pessoasMenoresQue16 = new StringBuilder();

        for (int i = 0; i < quantidade; i++){
            if (pessoas[i].getIdade() < 16){
                pessoasMenoresQue16.append(pessoas[i]);
            }
        }

        return pessoasMenoresQue16.toString();        
    }

    public static void estatisticas(){
        System.out.println();
        System.out.printf("Quantidade de pessoas: %d\n", 
            Data.quantidade());
        System.out.printf("Altura Média: %.2f\n", Data.alturaMedia());
        
        System.out.println();
        System.out.printf("Quantidade de pessoas menores que 16: %d\n", 
            Data.quantidadeMenoresQue16());            
        System.out.printf("Percentual de menores que 16: %.2f\n", 
            Data.percentualMenoresQue16());
        System.out.println("Pessoas menores que 16:");
        System.out.printf("%s", Data.pessoasMenoresQue16());
        System.out.println();
    }

}