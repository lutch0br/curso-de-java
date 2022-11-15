package section19.aula246.app;


import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Scanner;
import java.time.Instant;

import com.github.javafaker.Faker;

import section19.aula246.entities.LogEntry;
import section19.aula246.services.Access;
import util.Screen;


public class Program {

    static final Faker faker = new Faker();
    static final String path = "java-oo/src/section19/aula246/files/in.txt";
    static final File file = new File(path);
    static final Scanner sc = new Scanner(System.in);

    public static void main(String...args) throws Exception, InterruptedException {
        Locale.setDefault(Locale.US);
        Screen.clear();
    
        int option = 0;

        try{
            menu:            
            while (true) {

                try {
                    option = menu();
                    Screen.clear();

                    switch(option){
                        case 0:                    
                            break menu;
                        case 1:
                            generateAccessLog();
                            break;
                        case 2:
                            readAccessLog();
                            break;
                        case 3:                       
                            deleteAccessLog();
                            break;
                        default:                       
                            System.out.println("Invalid option...");
                            break;                            
                    }

                } catch(NumberFormatException e){
                    Screen.clear();
                    System.out.printf("Exception: %s\n", e.getMessage());
                }

                System.out.println();

            } 
        } catch(Exception e){
            System.out.printf("Exception: %s\n", e.getMessage());            
        } finally {
            System.out.printf("Finalizado...\n");
            sc.close();
        }
        sc.close();
    }

    static int menu()  throws InterruptedException {
        System.out.println("0 - Exit:");
        System.out.println("1 - Generate access log:");
        System.out.println("2 - Read access log:");
        System.out.println("3 - Delete access log:");

        System.out.print("Enter with the function number: ");
        // TimeUnit.SECONDS.sleep(3);
        return Integer.parseInt(sc.nextLine()); //faker.number().numberBetween(0, 4);        

    }    

    static void generateAccessLog(){
        

        if (file.exists()){
            System.out.printf("file %s exists...\n", file.getName());
        } else {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
                
                System.out.print("Input logs amount to generate: ");
                int quantity = Integer.parseInt(sc.nextLine());
                Access access = Access.getInstance();

                for (int i = 0; i < quantity; i++){
                    bw.write(access.getLogEntry().toString());
                    bw.newLine();
                }

                System.out.printf("file %s created...\n", file.getName());

            } catch (IOException e) {
                System.out.printf("%s\n", e.getMessage());
            }
        }
    }

    static void readAccessLog(){
        Set<LogEntry> logs = new TreeSet<>();
        
        if (file.exists()){
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String line = br.readLine();

                while(line != null){
                    logs.add(parseLogEntry(line));                    
                    line = br.readLine();                    
                }

                System.out.printf("Total users: %d\n", logs.size());

            } catch (IOException e){
                System.out.printf("IOException: %s\n", e.getMessage());
            }
        } else {
            System.out.println("File not exists...");
        }
    }

    private static LogEntry parseLogEntry(String line){
        String fields[] = line.split(",");
        Instant instant = Instant.parse(fields[0]);
        String user = fields[1];

        return new LogEntry(instant, user);
    }

    static void deleteAccessLog(){
        try{
            if (file.exists()){
                boolean del = file.delete();
                System.out.printf("%s deleted...%s\n", file.getName(), del);
            } else {
                throw new Exception("File not exists...");                
            }
        } catch (Exception e) {
            System.out.printf("%s\n", e.getMessage());
        }
    }
}
