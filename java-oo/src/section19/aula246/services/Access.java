package section19.aula246.services;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.Instant;

import com.github.javafaker.Faker;
import section19.aula246.entities.LogEntry;


public final class Access {
    private static Access instance;
    private List<String> users = new ArrayList<>();
    private Faker faker = new Faker();
    private Integer quantity;

    private Access() {
        // Generate name list
        for (int i = 0; i < 1000; i++){
            this.users.add(faker.name().firstName());
        }

        this.quantity = 1;
    }

    public static Access getInstance(){
        if (instance == null) {
            instance = new Access();            
        } 

        return instance;        
    }

    public LogEntry getLogEntry(){
        return new LogEntry(getInstant(), getUser());
    }

    private String getUser(){
        return faker.options().nextElement(users);
    }

    private Instant getInstant(){
        // Define instant interval 
        long start = 977616000000L + (31536000000L * quantity);
        long end = 977616000000L + (31536000000L * (quantity + 1));

        // Generate new instant between interval
        Long miliseconds = faker.number().numberBetween(start, end);
        Instant instant = (new Date(miliseconds)).toInstant();

        // Increment quantity
        quantity++;
        
        return instant;
    }

    public String toString(){
        return String.format("%s", getLogEntry());
    }
}