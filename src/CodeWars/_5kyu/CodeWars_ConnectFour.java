package CodeWars._5kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeWars_ConnectFour {

    static int[][] mappa = new int[6][7];
    static boolean turnoGiocatore1 = true;
    static boolean vittoria = false;
    static int[][] direzioniDaCercare = new int[][]{{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) {

//        https://www.codewars.com/kata/586c0909c1923fdb89002031
//        The game consists of a grid (7 columns and 6 rows) and two players that take turns to drop their discs.
//        The pieces fall straight down, occupying the next available space within the column.
//        The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs.
//
//        Your task is to create a Class called Connect4 that has a method called play which takes one argument
//        for the column where the player is going to place their disc.

//        Rules
//        If a player successfully has 4 discs horizontally, vertically or diagonally then you should return "Player n wins!”
//        where n is the current player either 1 or 2.
//
//        If a player attempts to place a disc in a column that is full then you should return ”Column full!”
//        and the next move must be taken by the same player.
//
//        If the game has been won by a player, any following moves should return ”Game has finished!”.
//
//        Any other move should return ”Player n has a turn” where n is the current player either 1 or 2.
//
//        Player 1 starts the game every time and alternates with player 2.
//
//        The columns are numbered 0-6 left to right.


        List<int[]> listaMosse = new ArrayList<>();
        listaMosse.add(new int[] { 4, 4, 4, 4, 4, 4, 4 }); // column full;

        for(int[] mosse : listaMosse){
            System.out.println("---------Inizio Partita---------");
            stampaMappa();
            for(int mossa : mosse){
                System.out.println(play(mossa));
                
            }
            stampaMappa();
            System.out.println("----------Fine Partita----------");
            // resettiamo la mappa dopo aver giocato, presumo che codewars lo faccia da se
            mappa = new int[6][7];


        }
    }
    public static String play(int column) {

        // caso in cui si cerca di inserire il pezzo in una colonna piena
        if(mappa[0][column] != 0) return "Column full!";


        // primo controllo per restituire game has finished
        if(vittoria) return "Game has finished!";

        // piazzamento pezzi
        // System.out.println("DEBUG INDICE VUOTO: " + trovaIndiceVuoto(column));
        mappa[trovaIndiceVuoto(column)][column] = (turnoGiocatore1) ? 1 : 2;
        turnoGiocatore1 = !turnoGiocatore1;

        // check vittoria dopo il piazzamento
        if(vittoria) return (turnoGiocatore1) ? "Player 1 wins!" : "Player 2 wins!";

        return (!turnoGiocatore1) ? "Player 1 has a turn" : "Player 2 has a turn";
    }
    public static int trovaIndiceVuoto(int colonna){
        for(int i = mappa.length -1; i > 0; i--){
            if(mappa[i][colonna] == 0) return i;
        }
        return 0;
    }

    public static void stampaMappa(){
        System.out.println("--------MAPPA---------");
        for(int[] s : mappa){
            System.out.print("\t");
            for(int rigo : s){
                System.out.print(rigo + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
}
