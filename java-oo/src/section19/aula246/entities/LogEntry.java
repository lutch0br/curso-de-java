package section19.aula246.entities;

import java.time.Instant;

import section19.aula246.services.Access;


public class LogEntry implements Comparable<LogEntry>{

    private Instant instant;
    private String user;

    public LogEntry(Instant instant, String user){
        this.instant = instant;
        this.user = user;
    }

    public String getUser(){
        return user;
    }

    public Instant getInstant(){
        return instant;
    }

    public String toString(){
        return String.format("%s,%s", getInstant(), getUser());
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object other){
        return super.equals(other);
    }

    @Override
    public int compareTo(LogEntry other){
        return user.compareTo(other.getUser());
    }
}