package CodeWars;
import java.util.*;

public class CodeWars_SimplePigLatin {
    public static String pigIt(String str) {

        String[] parole = str.split(" ");
        StringBuilder sbb = new StringBuilder();
        for(int i = 0; i < parole.length; i++){
            if(!Character.isAlphabetic(parole[i].charAt(0))){
                sbb.append(parole[i]);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for(int carattere = 0; carattere < parole[i].length(); carattere++){
                sb.append(parole[i].charAt(carattere));
                if(sb.length() == parole[i].length()){
                    char c = sb.charAt(0);
                    sb.deleteCharAt(0);
                    sb.append(c);
                    sb.append("ay");
                    sbb.append(sb + " ");
                }
            }
        }
        String ret = sbb.toString();
        return ret.trim();
    }
}