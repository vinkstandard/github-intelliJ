package CodeWars;
import java.util.*;

public class CodeWars_Mumbling {
    public static String accum(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
                for (int j = 0; j < i; j++) {
                    sb.append(Character.toLowerCase(c));
                }
            }
            sb.append("-");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
