package CodeWars;
import java.util.*;
public class CodeWars_MexicanWave {
    public static String[] wave(String str) {

        String[]wave1 = new String[str.length()];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            StringBuilder sb = new StringBuilder(str);
            if(Character.isAlphabetic(c)){
                sb.setCharAt(i,Character.toUpperCase(c));
                wave1[i] = sb.toString();
            }
            else{
                continue;
            }
        }
        ArrayList<String> wwave = new ArrayList<>(Arrays.asList(wave1));
        while(wwave.contains(null)){
            for(String s : wwave){
                if(s == null){
                    wwave.remove(s);
                    break;
                }
            }
        }
        return wwave.toArray(new String[0]);
    }
}
