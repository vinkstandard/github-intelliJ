package CodeWars._6kyu;

import java.util.*;

public class CodeWars_ImageHostFIlenameGenerator {


    public static void main(String[] args) {


        for(int i = 0; i < 5; i++){
            System.out.println(generateName());
        }
    }

    public static String generateName() {  // PhotoManager photoManager

        List<Character> caratteri = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            caratteri.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            caratteri.add(c);
        }

        String nome;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int randomIndex = (int)(Math.random() * caratteri.size());
                sb.append(caratteri.get(randomIndex));
            }
            nome = sb.toString();
        } while (photoManager.nameExists(nome));

        return nome;
    }
}




// TODO: Replace examples and use TDD by writing your own tests




