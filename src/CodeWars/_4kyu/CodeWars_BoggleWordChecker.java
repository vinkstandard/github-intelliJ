package CodeWars._4kyu;

public class CodeWars_BoggleWordChecker {

//    https://www.codewars.com/kata/57680d0128ed87c94f000bfd/train/java
//    Write a function that determines whether a string is a valid guess in a Boggle board, as per the rules of Boggle.
//    A Boggle board is a 2D array of individual characters, e.g.:
//
//          [ ['I','L','A','W'],
//            ['B','N','G','E'],
//            ['I','U','A','O'],
//            ['A','S','R','L'] ]
//
//    Valid guesses are strings which can be formed by connecting adjacent cells (horizontally, vertically, or diagonally)
//    without re-using any previously used cells.
//
//    For example, in the above board "BINGO", "LINGO", and "ILNBIA" would all be valid guesses, while "BUNGIE", "BINS", and "SINUS" would not.
//
//    Your function should take two arguments (a 2D array and a string)
//    and return true or false depending on whether the string is found in the array as per Boggle rules.
//
//    Test cases will provide various array and string sizes (squared arrays up to 150x150 and strings up to 150 uppercase letters).
//    You do not have to check whether the string is a real word or not, only if it's a valid guess.
    final private static char[][] board = {
            {'E', 'A', 'R', 'A'},
            {'N', 'L', 'E', 'C'},
            {'I', 'A', 'I', 'S'},
            {'B', 'Y', 'O', 'R'}
    };
    private static String[] toCheck = {"C", "EAR", "EARS", "BAILER", "RSCAREIOYBAILNEA", "CEREAL", "ROBES"};
    private static boolean[] expecteds = {true, true, false, true, true, false, false};

    public CodeWars_BoggleWordChecker(final char[][] board, final String word) {


    }

    public boolean check() {
        return false;
    }
}






//public static void main(String[] args) {
//    for(int i = 0; i < toCheck.length; i++){
//        System.out.println("PAROLA DA CONTROLLARE: " + toCheck[i] + ", ASPETTATIVA: " + expecteds[i]);
//    }
//}