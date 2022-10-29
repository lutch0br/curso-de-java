package section10.aula099.entities;

// TODO: Implementar com Lombok
public class Funcionario {

    private Integer id;
    private String nome;
    private Double salario;

    public Funcionario(Integer id, String nome, Double salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public Integer getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public Double getSalario(){
        return salario;
    }

    public void reajustarSalario(Double aumento){
        salario += salario * (aumento / 100);
    }

    public String toString(){
        return String.format("%03d   %-8s %8.2f",
            getId(), getNome(), getSalario());
    }
}