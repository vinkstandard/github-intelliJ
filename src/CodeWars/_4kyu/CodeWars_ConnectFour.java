package CodeWars._4kyu;

import java.util.*;

public class CodeWars_ConnectFour {
    public static void main(String[] args) {

         // https://www.codewars.com/kata/56882731514ec3ec3d000009/train/java
         // https://it.wikipedia.org/wiki/Forza_quattro

        List<String> myList = new ArrayList<String>(Arrays.asList(
                "C_Yellow",
                "B_Red",
                "B_Yellow",
                "E_Red",
                "D_Yellow",
                "G_Red",
                "B_Yellow",
                "G_Red",
                "E_Yellow",
                "A_Red",
                "G_Yellow",
                "C_Red",
                "A_Yellow",
                "A_Red",
                "D_Yellow",
                "B_Red",
                "G_Yellow",
                "A_Red",
                "F_Yellow",
                "B_Red",
                "D_Yellow",
                "A_Red",
                "F_Yellow",
                "F_Red",
                "B_Yellow",
                "F_Red",
                "F_Yellow",
                "G_Red",
                "A_Yellow",
                "F_Red",
                "C_Yellow",
                "C_Red",
                "G_Yellow",
                "C_Red",
                "D_Yellow",
                "D_Red",
                "E_Yellow",
                "D_Red",
                "E_Yellow",
                "C_Red",
                "E_Yellow",
                "E_Red"
        ));
        String s = whoIsWinner(myList);
        System.out.println("VINCITORE: "+ s);

    }
    public static String whoIsWinner(List<String> piecesPositionList) {
        // retrun "Red" or "Yellow" or "Draw"

        char[][]mappa = new char[6][7];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                mappa[i][j] = '-';
            }
        }
        int lunghezzaRigo = mappa.length, lunghezzaStringa = mappa[0].length;
        for(String s : piecesPositionList){
            int posizione = s.charAt(0) - 65; // -65 perché il valore numerico di un char è il suo valore in ascii, rimuovendo 65 ottengo l'indice che mi serve.
            if(s.contains("Yellow")){
                for(int i = lunghezzaRigo-1; i >= 0; i--){
                    if(mappa[i][posizione] == '-'){
                        mappa[i][posizione] = 'Y';
                        break;
                    }
                }
            }
            if(s.contains("Red")){
                for(int i = lunghezzaRigo-1; i >= 0; i--){
                    if(mappa[i][posizione] == '-'){
                        mappa[i][posizione] = 'R';
                        break;
                    }
                }
            }
            char vincitore  = verificaVittoria(mappa);
            if(vincitore != 'D'){
                switch(vincitore){
                    case 'Y': return "Yellow";
                    case 'R': return "Red";
                }
            }
        }
        stampaMappaDebug(mappa);
        char vincitore  = verificaVittoria(mappa);
        switch(vincitore){
            case 'Y': return "Yellow";
            case 'R': return "Red";
            case 'D': return "Draw";
        }
        return null;
    }

        public static void stampaMappaDebug(char[][]mappa){
        for(int i = 0; i < mappa.length; i++){
            for(int j = 0; j < mappa[0].length; j++){
                System.out.print(mappa[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static char verificaVittoria(char[][] mappa) {
        // controllo orizzontale
        for (int riga = 0; riga < 6; riga++) {
            for (int colonna = 0; colonna < 4; colonna++) {  // fino alla colonna 3
                if (mappa[riga][colonna] != '-' && mappa[riga][colonna] == mappa[riga][colonna + 1]
                        && mappa[riga][colonna] == mappa[riga][colonna + 2]
                        && mappa[riga][colonna] == mappa[riga][colonna + 3]) {
                    return mappa[riga][colonna];
                }
            }
        }

        // controllo verticale
        for (int colonna = 0; colonna < 7; colonna++) {
            for (int riga = 0; riga < 3; riga++) {  // fino alla riga 2
                if (mappa[riga][colonna] != '-' && mappa[riga][colonna] == mappa[riga + 1][colonna]
                        && mappa[riga][colonna] == mappa[riga + 2][colonna]
                        && mappa[riga][colonna] == mappa[riga + 3][colonna]) {
                    return mappa[riga][colonna];
                }
            }
        }

        // controllo diagonale (diagonale principale)
        for (int riga = 0; riga < 3; riga++) {  // fino alla riga 2
            for (int colonna = 0; colonna < 4; colonna++) {  // fino alla colonna 3
                if (mappa[riga][colonna] != '-' && mappa[riga][colonna] == mappa[riga + 1][colonna + 1]
                        && mappa[riga][colonna] == mappa[riga + 2][colonna + 2]
                        && mappa[riga][colonna] == mappa[riga + 3][colonna + 3]) {
                    return mappa[riga][colonna];
                }
            }
        }

        // controllo diagonale (diagonale inversa)
        for (int riga = 3; riga < 6; riga++) {  // fino alla riga 5
            for (int colonna = 0; colonna < 4; colonna++) {  // fino alla colonna 3
                if (mappa[riga][colonna] != '-' && mappa[riga][colonna] == mappa[riga - 1][colonna + 1]
                        && mappa[riga][colonna] == mappa[riga - 2][colonna + 2]
                        && mappa[riga][colonna] == mappa[riga - 3][colonna + 3]) {
                    return mappa[riga][colonna];
                }
            }
        }
        return 'D';
    }
}
