package CodeAbbey;
import java.util.*;
public class CodeAbbey_BrokenKeyboard {
    public static void main(String[] args) {
//        Paolo Durno founds his keyboard has a key B broken. But it not simply just "not types in the char"! Besides this obvious
//        effect, it mystically deletes some one of preceding characters: either the nearest previous capital or small letter,
//        depending on whether the button was pressed with Shift or without (i.e. whether B or b was to be typed).
//
//        The goal is, by the given string, to produce the result of typing it with this curious keyboard.
//
//        Input provides a count of testcases to follow in the first line.
//        Next lines contain single testcase each, in a form of strings, constiting only of latin letters.
//
//        Answer should provide resulting malformed strings, space separated.
//
//        Example:
//
//        input:
//
//        1
//        YetAnotherBrokenKeyboard
//        answer:
//        YetnotherrokenKeoard

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int j = 0; j < n; j++) {
            String stringa = scanner.nextLine();
            while (controlloB(stringa)) {
                for (int i = 0; i < stringa.length(); i++) {
                    if (stringa.charAt(i) == 'B') {
                        stringa = bGrande(stringa, i);
                        break;
                    }
                    if (stringa.charAt(i) == 'b') {
                        stringa = bPiccola(stringa, i);
                        break;
                    }
                }
            }
            System.out.print(stringa + " ");
        }
    }

    public static String bGrande(String s, int indice) {
        StringBuilder sb = new StringBuilder(s);
        if (s.charAt(0) == 'B') {
            sb.deleteCharAt(0);
            return sb.toString();
        }
        if (indice >= 1) {
            for (int i = indice - 1; i >= 0; i--) {
                if (Character.isUpperCase(s.charAt(i)) && s.charAt(i) != 'b' && s.charAt(i) != 'B') {
                    sb.deleteCharAt(indice);
                    sb.deleteCharAt(i);
                    return sb.toString();
                }
            }
        }
        sb.deleteCharAt(indice);
        return sb.toString();
    }

    public static String bPiccola(String s, int indice) {
        StringBuilder sb = new StringBuilder(s);
        if (s.charAt(0) == 'b') {
            sb.deleteCharAt(0);
            return sb.toString();
        }
        if (indice >= 1) {
            for (int i = indice - 1; i >= 0; i--) {
                if (Character.isLowerCase(s.charAt(i)) && s.charAt(i) != 'b' && s.charAt(i) != 'B') {
                    sb.deleteCharAt(indice);
                    sb.deleteCharAt(i);
                    return sb.toString();
                }
            }
        }
        sb.deleteCharAt(indice);
        return sb.toString();
    }

    public static boolean controlloB(String s) {
        return s.contains("B") || s.contains("b");
    }
}
