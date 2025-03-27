package CodeWars._6kyu;

public class CodeWars_WordA10NAbbreviation {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/5375f921003bf62192000746/train/java
        //  "elephant-rides are really fun!" = "e6t-r3s are r4y fun!"
        // "mat_is doggy" = "mat_is d3y"
        // "internationalization internationalizationX" = "i18n i19X"
        // "sits-double-barreled-on" = "s2s-d4e-b6d-on"
        String s = "sits-double-barreled-on";
        System.out.println(abbreviate(s));


    }
    public static String abbreviate(String string) {

        StringBuilder sb = new StringBuilder();
        StringBuilder sbb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isAlphabetic(c)) {
                sbb.append(c);
            } else {
                if (sbb.length() > 3) {
                    sb.append(sbb.charAt(0)).append(sbb.length() - 2).append(sbb.charAt(sbb.length() - 1));
                    sb.append(c);
                } else {
                    sb.append(sbb);
                    sb.append(c);
                }
                sbb = new StringBuilder();
            }
        }
        if (!sbb.isEmpty()) {
            if (sbb.length() > 3) {
                sb.append(sbb.charAt(0)).append(sbb.length() - 2).append(sbb.charAt(sbb.length() - 1));
            } else {
                sb.append(sbb);
            }
        }
        return sb.toString();
    }
}
