package CodeWars;
import java.util.*;
public class CodeWars_CatAndMouse {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/57ee2a1b7b45efcf700001bf javascript
//        https://www.codewars.com/kata/57ee24e17b45eff6d6000164 java
//        You will be given a string (x) featuring a cat 'C', a dog 'D' and a mouse 'm'. The rest of the string will be made up of '.'.
//        You need to find out if the cat can catch the mouse from its current position. The cat can jump at most (j) characters, and cannot jump over the dog.
//         So: if j = 5:
//         ..C.....m...D returns 'Caught!' <-- not more than j characters between the cat and the mouse
//         .....C............m......D returns 'Escaped!' <-- as there are more than j characters between the two, the cat cannot jump far enough
//         if j = 10
//         ...m.........C...D returns 'Caught!' <-- Cat can jump far enough and jump is not over dog
//         ...m....D....C....... returns 'Protected!' <-- Cat can jump far enough, but dog is in the way, protecting the mouse
        String s = "...m.........C...D";
        int j = 10;
        System.out.println(catMouse(s, j));


    }

    public static String catMouse(String x, int salto) {
        List<Character> caratteri = x.chars().mapToObj(c -> (char) c).toList();

        if (!caratteri.contains('C') && !caratteri.contains('D') && !caratteri.contains('m')) {
            return "boring without all three";
        }
        boolean davanti = caratteri.indexOf('C') < caratteri.indexOf('m');
        int increment = 0;

        while (increment < salto + 1) {
            if (davanti) {
                for (int i = caratteri.indexOf('C'); i < x.length(); i++) {
                    char c = x.charAt(i);
                    if (c == 'C') {continue;}
                    if (increment < salto + 1) {
                        if (c == 'D') {return "Protected!";}
                        else if (c == 'm') {return "Caught!";}
                        increment++;
                    }
                }
            } else{
                for (int i = caratteri.indexOf('C'); i >= 0; i--) {
                    char c = x.charAt(i);
                    if (c == 'C') {continue;}
                    if (increment < salto) {
                        if (c == 'D') {return "Protected!";}
                        else if (c == 'm') {return "Caught!";}
                        increment++;
                    }
                }
            }
        }
        return "Escaped!";
    }
}
