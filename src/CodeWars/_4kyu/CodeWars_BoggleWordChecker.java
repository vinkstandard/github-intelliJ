package CodeWars._4kyu;

public class CodeWars_BoggleWordChecker {
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