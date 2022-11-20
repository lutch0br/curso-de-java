package section21.aula268.tests;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Test {
    public static void main(String...args) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"))){               
            bw.write("e aí mundão, firmeza?");
            System.out.println("test...");
        } catch (IOException e){

        }

        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))){               
            String line = br.readLine();
            if (line != null)
                System.out.printf("%s\n", line);
        } catch (IOException e){

        }    


        try (FileOutputStream fs = new FileOutputStream("db.properties")){
            //Properties p = new Properties();
            // p.load(fs);
            fs.write(65);            
        } catch(IOException e){

        }
    }
}