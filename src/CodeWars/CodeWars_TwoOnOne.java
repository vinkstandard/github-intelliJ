package CodeWars;
import java.util.*;
public class CodeWars_TwoOnOne {
    public static String longest (String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        StringBuilder sb = new StringBuilder();
        for(char c : chars1){
            boolean contains = sb.indexOf(String.valueOf(c)) != -1;
            if(!contains){
                sb.append(c);
            }
            for(char b : chars2){
                contains = sb.indexOf(String.valueOf(b)) != -1;
                if(!contains){
                    sb.append(b);
                }
            }
        }
        char[] good = sb.toString().toCharArray();
        Arrays.sort(good);
        return new String(good);
    }
}