package section10.aula093.entities;


public class Quarto {
    private String nome;
    private String email;
    private Integer quarto;

    public Quarto(String nome, String email, Integer quarto){
        this.nome = nome;
        this.email = email;
        this.quarto = quarto;
    }

    public String toString(){
        return String.format("%s: %s, %s", quarto, nome, email);
    }
}