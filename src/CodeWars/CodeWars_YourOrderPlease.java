package CodeWars;

import java.util.*;

public class CodeWars_YourOrderPlease {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/55c45be3b2079eccff00010f
//        "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
//        "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
        String s = "4of Fo1r pe6ople g3ood th5e the2";
        System.out.println("STRINGA NON ORDINATA: " + s);
        System.out.println("STRINGA ORDINATA: " +order(s));

    }
    public static String order(String words) {

        if(words.isEmpty()){return "";}
        int valoreIniziale = 1;
        ArrayList<String> paroleOrdinate = new ArrayList<>();
        String[] parole = words.split(" ");
        StringBuilder sb = new StringBuilder();
        while (paroleOrdinate.size() != parole.length) {
            for (String s : parole) {
                if (s.contains(String.valueOf(valoreIniziale)) && !paroleOrdinate.contains(s)) {
                    paroleOrdinate.add(s);
                    sb.append(s).append(" ");
                    valoreIniziale++;
                }
            }
        }
        return sb.toString().trim();
    }
}
