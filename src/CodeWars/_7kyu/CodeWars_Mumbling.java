package CodeWars._7kyu;

public class CodeWars_Mumbling {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5667e8f4e3f572a8f2000039
//        This time no story, no theory. The examples below show you how to write function accum:
//        Examples:
//        accum("abcd") -> "A-Bb-Ccc-Dddd"
//        accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
//        accum("cwAt") -> "C-Ww-Aaa-Tttt"
//        The parameter of accum is a string which includes only letters from a..z and A..Z.

        String s = "abcd";
        System.out.println(accum(s));
    }

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
