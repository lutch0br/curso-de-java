package section19.aula249.app;


import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import com.github.javafaker.Faker;

import util.Screen;


/**
* Na contagem de votos de uma eleição, são gerados vários registros
* de votação contendo o nome do candidato e a quantidade de votos
* (formato .csv) que ele obteve em uma urna de votação. Você deve
* fazer um programa para ler os registros de votação a partir de um
* arquivo, e daí gerar um relatório consolidado com os totais de cada
* candidato.
*/
public class Program {
    final static Faker faker = new Faker();
    final static File file = new File("java-oo/src/section19/aula249/files/votes.csv");

    public static void main(String...args){
        Screen.clear();       
        Scanner sc = new Scanner(System.in);
        
        menu:
        while(true){
            System.out.println("0 - Exit: ");
            System.out.println("1 - Make vote log: ");
            System.out.println("2 - Read vote log: ");
            System.out.println("3 - Del vote log: ");
            System.out.print("Choose an option: ");
            
            int option = 0;

            try{
                option = Integer.parseInt(sc.nextLine());
                Screen.clear();

                switch(option){
                    case 0:
                        break menu;
                    case 1:
                        makeVoteLog();
                        break;
                    case 2:
                        readVoteLog();
                        break;
                    case 3:
                        deleteVoteLog();
                        break;
                    default:
                        System.out.println("Choose a valid option...");
                        break;
                }
            } catch(NoSuchElementException e){
                Screen.clear();
                System.out.printf("%s\n", e.getMessage());  
                break menu;              
            } catch(NumberFormatException e){  
                Screen.clear();
                System.out.printf("%s\n", e.getMessage());
            }

            System.out.println();
        }

        sc.close();
        System.out.println("Finalizando...");
    }

    static void makeVoteLog(){
        if (file.exists()){
            System.out.println("File exists... ");
        } else {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
                Set<String> candidates = new HashSet<>();

                for (int i = 0; i < 5; i++)
                    candidates.add(faker.name().fullName());

                for(int i = 0; i < 20; i++){
                    String name = faker.options().nextElement(new ArrayList<>(candidates));
                    Integer vote = faker.number().numberBetween(5, 50);
                    Vote v = new Vote(name, vote);
                    bw.write(v.toString());
                    bw.newLine();
                }
                System.out.printf("%s created...\n", file.getName());
            } catch(IOException e){
                System.out.printf("%s", e.getMessage());
            }
        }
    }

    static void readVoteLog(){
        if (file.exists()){        
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                Map<String, Integer> score = new HashMap<>();

                String line = br.readLine();

                while (line != null){
                    String fields[] = line.split(",");
                    String name = fields[0];
                    Integer votes = Integer.parseInt(fields[1]);                    
                    if (score.containsKey(name)){
                        votes += score.get(name);
                    }

                    score.put(name, votes);

                    line = br.readLine();
                }

                for (String name : score.keySet()){
                    System.out.printf("%s : %d\n", name, score.get(name));
                }

            } catch(IOException e){
                System.out.printf("%s", e.getMessage());
            }
        } else {
            System.out.println("File not exists... ");
        }
    }

    static void deleteVoteLog(){        
        try {
            if (file.exists()){
                file.delete();
                System.out.printf("%s deleted\n", file.getName());
            } else {
                throw new FileNotFoundException("File not exists...\n");
            }
        } catch (IOException e) {
            System.out.printf("%s", e.getMessage());
        }
    }
}