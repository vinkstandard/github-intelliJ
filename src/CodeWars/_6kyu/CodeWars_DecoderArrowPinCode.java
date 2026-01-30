package CodeWars._6kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeWars_DecoderArrowPinCode {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/69178eb3a22411a3aab31347
//                +---+---+---+     +---sticker---+
//                | 7 | 8 | 9 |     |             |
//                +---+---+---+     |  1→↑→       |
//                | 4 | 5 | 6 |     |             |
//                +---+---+---+     |             |
//                | 1 | 2 | 3 |     +-------------+
//                +---+---+---+   presumably encoded
//                | 0 |                1256
//                +---+
//
//        Your task is to write a decoder function for the arrow pin code that takes a string as input and returns a list containing a sequence of digits.
//
//        The sticker contains between 4 and 8 characters.
//        The PIN code on the sticker always begins with a digit and contains at least one arrow.
//        There are no more than four types of arrows on the stickers ↓, ↑, →, ←.
//        In addition to the first digit, the sticker may contain another digit with an asterisk *n, which probably indicates the number of times the previous key was pressed.
//        The digit is always in the range 0 < *n < 10.
//        The sticker may contain an incorrect PIN code consisting of an incorrect combination of arrows that goes beyond the digital keypad. In this case, return [].
//        Examples
//        correct sequence of arrows
//
//        "1→↑→"       ==>   [1, 2, 5, 6]
//        "1*2↓"       ==>   [1, 1, 1, 0]
//        "0*2↑"       ==>   [0, 0, 0, 1]
//        "0↑↑↑"       ==>   [0, 1, 4, 7]
//        "5↓*1←↑↓"    ==>   [5, 2, 2, 1, 4, 1]
//        "1→→↑↑←←↓↓"  ==>   [1, 2, 3, 6, 9, 8, 7, 4, 1]
//        incorrect sequence of arrows
//
//        "0↑↑↑↑"      ==>   []
//        "8↑*5→"      ==>   []
//        "0←*2←"      ==>   []
//        "8↑↑↑"       ==>   []
//        "3↓←*4↑"     ==>   []
//        "6→←→↓↑"     ==>   []
        System.out.println(Arrays.toString(decArrowPinCode("1→↑→")) + "\tAtteso: " + Arrays.toString(new int[]{1, 2, 5, 6}));
        System.out.println(Arrays.toString(decArrowPinCode("1*2↓")) + "\tAtteso: " + Arrays.toString(new int[]{1, 1, 1, 0}));
        System.out.println(Arrays.toString(decArrowPinCode("0↑↑↑")) + "\tAtteso: " + Arrays.toString(new int[]{0, 1, 4, 7}));
        System.out.println(Arrays.toString(decArrowPinCode("8↑*5→")) + "\tAtteso: " + Arrays.toString(new int[]{}));
        System.out.println(Arrays.toString(decArrowPinCode("0←*2←")) + "\tAtteso: " + Arrays.toString(new int[]{}));
    }

    public static int[] decArrowPinCode(String arrowStr) {

        int[][] pad = new int[][]{
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3},
                {0, -1, -1}
        };
        List<Integer> lista = new ArrayList<>();
        int[] pos = getPosizioneAttuale(arrowStr.charAt(0));
        lista.add(pad[pos[0]][pos[1]]); // aggiungo il primo numero

        for (int i = 1; i < arrowStr.length(); i++) {
            char carattereAttuale = arrowStr.charAt(i);

            if (carattereAttuale == '*') {
                int nVolte = Character.getNumericValue(arrowStr.charAt(i + 1));
                int ultimoNum = lista.get(lista.size() - 1);
                for (int ripetizione = 0; ripetizione < nVolte; ripetizione++) {
                    lista.add(ultimoNum);
                }
                i++; // saltiamo il numero dopo l'asterisco
                continue;
            }
            switch (carattereAttuale) {
                case '→' -> pos[1]++;
                case '↑' -> pos[0]--;
                case '←' -> pos[1]--;
                case '↓' -> pos[0]++;
            }
            if (pos[0] < 0 || pos[0] >= 4 || pos[1] < 0 || pos[1] >= 3 || pad[pos[0]][pos[1]] == -1) {
                return new int[]{};
            } else {
                lista.add(pad[pos[0]][pos[1]]);
            }
        }
        return lista.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getPosizioneAttuale(char carattere) {
        int[] pos = new int[2];
        switch (carattere) {
            case '8' -> pos[1] = 1;
            case '9' -> pos[1] = 2;
            case '4' -> pos[0] = 1;
            case '5' -> {
                pos[0] = 1;
                pos[1] = 1;
            }
            case '6' -> {
                pos[0] = 1;
                pos[1] = 2;
            }
            case '1' -> pos[0] = 2;
            case '2' -> {
                pos[0] = 2;
                pos[1] = 1;
            }
            case '3' -> {
                pos[0] = 2;
                pos[1] = 2;
            }
            case '0' -> pos[0] = 3;
        }
        return pos;
    }
}
