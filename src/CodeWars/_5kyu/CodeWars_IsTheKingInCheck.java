package CodeWars._5kyu;

import java.util.HashMap;
import java.util.Map;

public class CodeWars_IsTheKingInCheck {
    public static void main(String[] args) {

        //  https://www.codewars.com/kata/5e28ae347036fa001a504bbe/train/java
        final char[][] test8 = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'R', ' ', 'B', 'K', ' ', ' ', ' ', ' '},
                {' ', ' ', 'P', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};

        final char[][] test2 = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', 'K', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'N', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
        System.out.println(isTheKinginCheck(test2));

    }

    public static boolean isTheKinginCheck(char[][] chessboard) {
        Map<String, Character> map = fillMap(chessboard);
        for (Map.Entry<String, Character> entry : map.entrySet()) {
            String[] coords = entry.getKey().split(",");
            char piece = entry.getValue();
            int x = Integer.parseInt(coords[0]), y = Integer.parseInt(coords[1]);
            if (piece == 'Q' || piece == 'B') {
                if (checkDiagonals(x, y, chessboard)) return true;
            }
            if (piece == 'Q' || piece == 'R') {
                if (checkTowerMove(x, y, chessboard)) return true;
            }
            if (piece == 'N') {
                if (checkKnightMove(x, y, chessboard)) return true;
            }
            if (piece == 'P') {
                int[][] pawnMoves = new int[][]{{1, -1}, {1, 1}};
                for (int[] pawnMove : pawnMoves) {
                    int newX = x + pawnMove[0], newY = y + pawnMove[1];
                    if (isInBounds(newX, newY, chessboard)) {
                        if (chessboard[newX][newY] == 'K') return true;
                    }
                }
            }
        }
        return false;
    }

    public static Map<String, Character> fillMap(char[][] chessboard) {
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[0].length; j++) {
                if (chessboard[i][j] != ' ') {
                    String coords = i + "," + j;
                    char piece = chessboard[i][j];
                    if (piece == 'K') continue;
                    map.put(coords, piece);
                }
            }
        }
        return map;
    }

    public static boolean checkDiagonals(int x, int y, char[][] chessboard) {
        // 0 0
        int[][] moves = new int[][]{{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        for (int[] move : moves) {
            int newX = x + move[0], newY = y + move[1];
            while (isInBounds(newX, newY, chessboard)) {
                if (chessboard[newX][newY] == 'K') return true;
                if (chessboard[newX][newY] != 'K' && chessboard[newX][newY] != ' ') break;
                newX += move[0];
                newY += move[1];
            }
        }
        return false;
    }

    public static boolean checkTowerMove(int x, int y, char[][] chessboard) {
        int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] move : moves) {
            int newX = x + move[0], newY = y + move[1];
            while (isInBounds(newX, newY, chessboard)) {
                if (chessboard[newX][newY] == 'K') return true;
                if (chessboard[newX][newY] != 'K' && chessboard[newX][newY] != ' ') break;
                newX += move[0];
                newY += move[1];
            }
        }
        return false;
    }

    public static boolean checkKnightMove(int x, int y, char[][] chessboard) {
        int[][] moves = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for (int[] move : moves) {
            int newX = x + move[0], newY = y + move[1];
            if (isInBounds(newX, newY, chessboard)) {
                if (chessboard[newX][newY] == 'K') return true;
            }
        }
        return false;
    }

    public static boolean isInBounds(int x, int y, char[][] chessboard) {
        return x >= 0 && x < chessboard.length && y >= 0 && y < chessboard[0].length;
    }
}