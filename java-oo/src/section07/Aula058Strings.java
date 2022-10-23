package section07;

import java.util.Vector;
import util.Screen;

public class Aula058Strings{
    public static void main(String...args){

        String word = " Curso de Java ";

        String w1 = word.toLowerCase();
        String w2 = word.toUpperCase();
        String w3 = word.trim();
        String w4 = word.substring(4);
        String w5 = word.substring(3, 7);
        String w6 = word.replace('a', 'X');
        String w7 = word.replace("Java", "Kotlin");
        String w8 = String.valueOf(word.indexOf("J"));
        String w9 = String.valueOf(word.indexOf("a", 13));
        String[] w0 = word.split(" ");

        Screen.clear();
        System.out.printf("%-20s %-20s %s\n", 
            "ORIGINAL", "FUNCÃO", "CONVERTIDA");
        show(word, "toLowerCase", w1);
        show(word, "toUpperCase", w2);
        show(word, "trim", w3);
        show(word, "substring(i)", w4);
        show(word, "substring(i,f)", w5);
        show(word, "replace(char)", w6);
        show(word, "replace(str)", w7);
        show(word, "indexOf(str)", w8);
        show(word, "indexOf(str, i)", w9);
        show(word, "split", w0);
     }

    public static void show(String s1, Object f, Object s2){
        System.out.printf("%-20s %-20s %s\n", s1, f, s2.toString());
    }

    public static void show(String s1, Object f, String[] s2){
        System.out.printf(
            "%-20s %-20s %s,%s,%s,%s\n", s1, f, s2[0], s2[1], s2[2], s2[3]);
    }    
}
                