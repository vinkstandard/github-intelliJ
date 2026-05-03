package CodeWars._6kyu;

import java.util.HashMap;
import java.util.List;

public class CodeWars_OctoCoderTheTypingOctopus {
    public static void main(String[] args) {
//    https://www.codewars.com/kata/6809ffd5fcdb184cdb7592b6/train/java
        List<String> tests = List.of("Letter", "Unconcerned", "Can a can contain fish?", "Write 122 pages", "8000 dollars went missing", "");
        tests.forEach(test -> System.out.println(">>> Risultato: " + Octopus(test) + "\n----------------"));
    }

    public static String Octopus(String idea) {
        if(idea.isEmpty()) return "";
        System.out.println(">>> Parola iniziale: " + idea);

        HashMap<Character, Integer> mappaCaratteri = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int contatoreParole = 0;

        for(char carattere : idea.toCharArray()){

            if(Character.isAlphabetic(carattere) || !Character.isDigit(carattere)){
                if(mappaCaratteri.containsKey(Character.toLowerCase(carattere))){
                    sb.append("*");
                } else {
                    sb.append(carattere);
                    mappaCaratteri.put(Character.toLowerCase(carattere), 1);
                }
            } else {
                if(mappaCaratteri.containsKey(carattere)){
                    if(mappaCaratteri.get(carattere) == 2){
                        sb.append("*");
                    } else {
                        sb.append(carattere);
                        mappaCaratteri.put(carattere, 2);
                    }
                } else {
                    sb.append(carattere);
                    mappaCaratteri.put(carattere, 1);
                }
            }
            contatoreParole++;
            if(contatoreParole == 8){
                contatoreParole = 0;
                mappaCaratteri = new HashMap<>();
            }


        }
        return sb.toString();
    }
}
