package CodeWars;
import java.util.*;

public class CodeWars_Rot13 {
    public static String rot13(String str) {

        ArrayList<Character> alfabeto = new ArrayList<>();
        ArrayList<Character> rot13 = new ArrayList<>();
        for(char c = 'A'; c <= 'Z'; c++){
            alfabeto.add(c);                             // alfabeto normale
        }
        for(int i = 13; i < alfabeto.size(); i++){       // inizio l'alfabeto rot
            rot13.add(alfabeto.get(i));
        }
        for(char c = 'A'; c < 'N'; c++){                 // aggiungo le ultime lettere
            rot13.add(c);
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isLowerCase(c) && Character.isAlphabetic(c)){
                c = Character.toUpperCase(c);
                char carattere = rot13.get(alfabeto.indexOf(c));
                sb.append(Character.toLowerCase(carattere));
            }else{
                if(Character.isAlphabetic(c)) {
                    sb.append(rot13.get(alfabeto.indexOf(c)));
                }else{
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}


