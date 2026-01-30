package CodeWars._6kyu;

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
    }

    public static int[] decArrowPinCode(String arrowStr) {
        return new int[]{};
    }
}
