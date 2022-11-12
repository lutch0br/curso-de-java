package section17.aula220.app;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Locale;
import java.util.Scanner;

import section17.aula220.model.entities.Product;
import com.github.javafaker.Faker;

import util.Screen;

/**
* Programa que exibe um menu com opções para criar um arquivo no formato csv com
* produtos contendo nome, preço e quantidade.
* Exibe os produtos, calcular seus valores totais, salvando o valor total e um 
* novo arquivo.
* Atualmente implementado com a seleção automática das opções.
*/
public class Program {
    static final String path = "java-oo/src/section17/files/in.txt";
    static final String out = "java-oo/src/section17/files/summary.csv";
    static final Faker faker = new Faker();
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
                            createProductsFile();
                            break;
                        case 2:
                            readProductsFile(path);
                            break;
                        case 3:                       
                            calculateProductsFile();                       
                            break;
                        case 4:
                            readProductsFile(out);
                            break;                                        
                        case 5:
                            deleteAllFiles();
                            break;
                        default:
                            System.out.println("default");
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
    }

    static int menu()  throws InterruptedException {
        System.out.printf("0 - Exit: \n");
        System.out.printf("1 - Create products file: \n");
        System.out.printf("2 - Read products file: \n");
        System.out.printf("3 - Calculate products file: \n");
        System.out.printf("4 - Read products file calculated: \n");
        System.out.printf("5 - Delete all files: \n");

        System.out.print("Enter with the function number: ");
        TimeUnit.SECONDS.sleep(3);
        return faker.number().numberBetween(0, 6);        

    }

    static void createProductsFile(){
        
        File file = new File(path);
        
        if (file.exists()){
            System.out.printf("File already exists! Deleting file...%s\n", file.delete());
        }
        
        try {
            file.createNewFile();
            int productsAmount = 10;

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){

                for (int i = 0; i < productsAmount; i++){
                    String name = faker.commerce().productName();
                    double price = faker.number().randomDouble(2, 10, 500);
                    int quantity = faker.number().numberBetween(1, 10);
                    Product p = new Product(name, price, quantity);
                    bw.write(p.toString());
                    bw.newLine(); 
                                    
                }

                System.out.println("Products file created");                
            } catch(IOException e){
                e.printStackTrace();
            } 
        } catch(IOException e){
            System.out.printf("%s\n", e.getMessage());
        }
        
    }

    static void readProductsFile(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }
        } catch(IOException e){
            System.out.printf("%s\n", e.getMessage());
        }
    }

    static void calculateProductsFile(){         

        File file = new File(out);
        if (file.exists()){
            System.out.printf("File already exists! Deleting file...%s\n", file.delete());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();           

            while (line != null){

                String name = line.split(",")[0];
                double price = Double.parseDouble(line.split(",")[1]);
                int quantity = Integer.parseInt(line.split(",")[2]);
                Product product = new Product(name, price, quantity);

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out, true))){
                    String lineCalculated = 
                        String.format("%s,%.2f", product.getName(), product.getTotalValue());
                    bw.write(lineCalculated);
                    bw.newLine();                    
                } catch (IOException e){
                    System.out.printf("Exception: %s\n", 
                        e.getMessage());
                }

                line = br.readLine();
            }            
            
            System.out.println("File calculated");
        } catch (IOException e) {
            System.out.printf("Exception: %s\n", 
                e.getMessage());
        }
    }

    static void deleteAllFiles(){

        try {

            File file = new File(path);
            File folder = new File(file.getParent());
            File files[] = folder.listFiles();

            System.out.printf("Files amount: %d\n", files.length);

            if (files.length > 0){
                for (File f: files){
                    System.out.printf("File deleted: %s\n", f.getName());
                    f.delete();
                }
            } else {
                System.out.println("Nothing to delete...");
            }

        } catch(Exception e){

            System.out.printf("Exception: %s...\n", e.getMessage());

        }
    }
}