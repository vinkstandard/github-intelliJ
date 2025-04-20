package CodeWars._7kyu;

public class CodeWars_ScrollingText {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5a995c2aba1bb57f660001fd

//        Let's create some scrolling text!
//        Your task is to complete the function which takes a string, and returns an array with all possible rotations of the given string, in uppercase.
//
//        Example:
//        scrollingText("codewars") should return:
//
//        [ "CODEWARS",
//          "ODEWARSC",
//          "DEWARSCO",
//          "EWARSCOD",
//          "WARSCODE",
//          "ARSCODEW"
//          "RSCODEWA",
//          "SCODEWAR" ]
//        Good luck!

        String text = "codewars";
        String[] varianti = scrollingText(text);
        for (String s : varianti) {
            System.out.println(s);
        }
    }

    public static String[] scrollingText(String text) {

        String[] lista = new String[text.length()];
        for (int i = 0; i < text.length(); i++) {
            if (i == 0) {
                lista[i] = text.toUpperCase();
            } else {
                String parola = text.substring(i) + text.substring(0, i);
                lista[i] = parola.toUpperCase();
            }
        }
        return lista;
    }
}
