package section13.aula152.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private String name;
    private String email;
    private Date birthDate;

    public Client(String name, String email, Date birthDate){
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return String.format(
            "Client: %s  (%s) - %s\n",
            name, sdf.format(birthDate), email
        );
    }
}
