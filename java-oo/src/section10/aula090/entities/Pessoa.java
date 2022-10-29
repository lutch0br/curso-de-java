package section10.aula090.entities;


public class Pessoa{
    private String nome;
    private Integer idade;
    private Double altura;

    public Pessoa(String nome, Integer idade, Double altura){
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome(){
        return nome;
    }

    public Integer getIdade(){
        return idade;        
    }

    public Double getAltura(){
        return altura;
    }

    public String toString(){
        return String.format(
            "Nome: %s, Idade: %d, Altura: %.2f\n",
            getNome(),  getIdade(), getAltura()
        );
    }
}