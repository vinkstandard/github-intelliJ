package CodeWars._6kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeWars_AtomicChess {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/63deb6b0acb668000f87f01b/train/java

//        (2) Moves are denoted using the initial square and destination square, with -
//        indicating a regular move and x a capture. E.g. the Nxp capture described above is f3xe5.
//        If instead the white knight returned to its home square, that would be f3-g1.

        System.out.println("---------------------------------");
        final char[][] queenCapture = {
                {'r','n','b','q','k','b','.','r'},
                {'p','.','p','.','.','p','p','p'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','p','.','.','.'},
                {'.','.','.','.','P','.','.','.'},
                {'.','Q','.','.','.','.','.','.'},
                {'P','P','P','.','.','P','P','P'},
                {'R','N','B','.','K','B','N','R'}
        };

        final char[][] queenCaptureResult = {
                {'.','.','.','q','k','b','.','r'},
                {'p','.','p','.','.','p','p','p'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','p','.','.','.'},
                {'.','.','.','.','P','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'P','P','P','.','.','P','P','P'},
                {'R','N','B','.','K','B','N','R'}
        };


        stampa2d(makeAtomicMove(queenCapture, "b3xb8"));
        System.out.println("\nPrevisto: \n");
        stampa2d(queenCaptureResult);
        System.out.println("---------------------------------");



        char[][] rookCapture = {
                {'.','.','.','.','.','.','.','k'},
                {'.','B','.','r','p','.','.','.'},
                {'.','p','.','q','r','.','.','.'},
                {'.','.','N','.','.','P','.','.'},
                {'.','P','k','p','.','b','.','.'},
                {'.','.','p','.','B','.','.','.'},
                {'.','.','.','Q','P','.','P','.'},
                {'.','.','.','.','.','K','.','.'}
        };
        String mossaRook = "e6xe3";
        final char[][] rookCaptureResult = {
                {'.','.','.','.','.','.','.','k'}, // 8 -> i[7]     a = j[0]
                {'.','B','.','r','p','.','.','.'}, // 7 -> i[6]     b = j[1]
                {'.','p','.','q','.','.','.','.'}, // 6
                {'.','.','N','.','.','P','.','.'}, // 5
                {'.','P','k','p','.','.','.','.'}, // 4
                {'.','.','p','.','.','.','.','.'}, // 3
                {'.','.','.','.','P','.','P','.'}, // 2
                {'.','.','.','.','.','K','.','.'}  // 1
        };
        stampa2d(makeAtomicMove(rookCaptureResult, mossaRook));
        System.out.println("\nPrevisto: \n");
        stampa2d(rookCaptureResult);

    }
    public static char[][] makeAtomicMove(final char[][] position, final String move) {

        char[][] modificato = new char[position.length][];
        for (int i = 0; i < position.length; i++) {
            modificato[i] = Arrays.copyOf(position[i], position[i].length);
        }

        String tipoMossa = "" + move.charAt(2);
        List<String> posizioniPulite = creaListaFormattata(move, tipoMossa);

        System.out.println("Pos pulite: " + posizioniPulite);
        
        if(tipoMossa.equals("-")){

        } else {

        }




        return position;
    }

    public static List<String> creaListaFormattata(final String move, String tipoMossa){
        // finisci di convertire bene tutti i valori prima di pensare a fare le catture
        List<String> posizioni = new ArrayList<>();
        for(String posizioneRaw : move.split(tipoMossa)){
            String i = "", j = "";
            j = switch (posizioneRaw.charAt(0)) {
                case 'a' -> "0";
                case 'b' -> "1";
                case 'c' -> "2";
                case 'd' -> "3";
                case 'e' -> "4";
                case 'f' -> "5";
                case 'g' -> "6";
                case 'h' -> "7";
                default -> j;
            };
            i = switch (posizioneRaw.charAt(1)){
                case '8' -> "0";
                case '7' -> "1";
                case '6' -> "2";
                case '5' -> "3";
                case '4' -> "4";
                case '3' -> "5";
                case '2' -> "6";
                case '1' -> "7";
                default -> i;
            };
            posizioni.add(i + "," + j);
        }
        return posizioni;
    }
    public static void stampa2d(char[][] arr){
        for (char[] chars : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

}
