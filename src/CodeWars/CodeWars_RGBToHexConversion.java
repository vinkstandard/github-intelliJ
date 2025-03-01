package CodeWars;
import java.util.*;

public class CodeWars_RGBToHexConversion {
    public static String rgb(int r, int g, int b) {

        if(r > 255) r = 255;
        if(g > 255) g = 255;
        if(b > 255) b = 255;
        if(r < 0) r = 0;
        if(g < 0) g = 0;
        if(b < 0) b = 0;

        String s = String.format("#%02X%02X%02X", r, g, b);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(sb.length() == 7){
                break;
            }
            sb.append(c);
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }
}
