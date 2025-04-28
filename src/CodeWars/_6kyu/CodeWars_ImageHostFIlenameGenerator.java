package CodeWars._6kyu;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class CodeWars_ImageHostFIlenameGenerator {
    public static class PhotoManager {
        private final Set<String> existingNames;

        public PhotoManager() {
            existingNames = new HashSet<>();
        }

        public boolean nameExists(String name) {
            return existingNames.contains(name);
        }

        // metodo per aggiungere un nome se passa il check nameExists()
        public void addName(String name) {
            existingNames.add(name);
        }
        public Set<String> getNames(){
            return existingNames;
        }
    }


    public static void main(String[] args) {

        PhotoManager photoManager = new PhotoManager();

        // aggiungiamo già degli url
        photoManager.addName("CIAOCI");
        photoManager.addName("abcDEF");
        photoManager.addName("AAAAAA");

        // facciamo 10 casi
        for (int i = 0; i < 10; i++) {
            photoManager.addName(generateName(photoManager));
        }

        // stampa per debug
        System.out.println(photoManager.getNames());
    }

    public static String generateName(PhotoManager photoManager) {  // PhotoManager photoManager

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