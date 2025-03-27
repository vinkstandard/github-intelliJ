package CodeWars._5kyu;
public class CodeWars_RGBToHexConversion {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/513e08acc600c94f01000001
//        The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range must be rounded to the closest valid value.
//
//        Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
//
//        Examples (input --> output):
//        255, 255, 255 --> "FFFFFF"
//        255, 255, 300 --> "FFFFFF"
//        0, 0, 0       --> "000000"
//        148, 0, 211   --> "9400D3"

        int r = 148, g = 0, b = 211;
        System.out.println(rgb(r,g,b));
    }
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
