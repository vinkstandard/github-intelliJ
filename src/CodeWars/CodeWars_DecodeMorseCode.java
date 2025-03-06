package CodeWars;
import java.util.*;

public class CodeWars_DecodeMorseCode {
    public static void main(String[] args) {

        // questo esercizio usa una library "MorseCode"(rigo 23) che è built in, c'è poco da spiegare, clicca sul link.
        // https://www.codewars.com/kata/54b724efac3d5402db00065e/train/java
        String morse = ".... . -.--   .--- ..- -.. ."; // HEY JUDE
        System.out.println(decode(morse));
    }
    public static String decode(String morseCode) {

            StringBuilder sb = new StringBuilder();
            String[]splitted = morseCode.split(" ");
            int contoSpazi = 0;
            for(int i = 0; i < splitted.length; i++){
                String s = splitted[i];
                if(s.isEmpty()){
                    contoSpazi++;
                }else{
                    sb.append(MorseCode.get(s));
                    contoSpazi = 0;
                }
                if(contoSpazi == 2){
                    sb.append(" ");
                    contoSpazi = 0;
                }
            }
            while(sb.charAt(0) == ' '){
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
    }
