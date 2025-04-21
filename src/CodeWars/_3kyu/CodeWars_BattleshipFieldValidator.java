package CodeWars._3kyu;

public class CodeWars_BattleshipFieldValidator {
    public static void main(String[] args) {
///       https://www.codewars.com/kata/52bb6539a4cf1b12d90005b7/train/java
//        Write a method that takes a field for well-known board game "Battleship" as an argument and returns true if it has a valid disposition of ships,
//        false otherwise. Argument is guaranteed to be 10*10 two-dimension array.
//
//        Elements in the array are numbers, 0 if the cell is free and 1 if occupied by ship.
//        Battleship (also Battleships or Sea Battle) is a guessing game for two players.
//        Each player has a 10x10 grid containing several "ships" and objective is to destroy enemy's forces by targetting individual cells on his field.
//        The ship occupies one or more cells in the grid. Size and number of ships may differ from version to version.
//        In this kata we will use Soviet/Russian version of the game.
//
//        Before the game begins, players set up the board and place the ships accordingly to the following rules:
//        There must be single battleship (size of 4 cells), 2 cruisers (size 3), 3 destroyers (size 2) and 4 submarines (size 1).
//        Any additional ships are not allowed, as well as missing ships.
//        Each ship must be a straight line, except for submarines, which are just single cell.

        int[][] battleField = {
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println(fieldValidator(battleField));


    }

    public static boolean fieldValidator(int[][] field) {

        printMappa(field); // debug
        return false;

        // validità della values,
        // 1 da 4
        // 2 da 3
        // 3 da 2
        // 4 da 1

        // e check per gli overlap o contact
    }









    public static void printMappa(int[][] field){
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}
