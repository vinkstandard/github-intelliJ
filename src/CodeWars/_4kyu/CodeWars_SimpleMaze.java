package CodeWars._4kyu;

import java.util.*;

public class CodeWars_SimpleMaze {
    public static void main(String[] args) {
        
        String[] simpleExit = new String[] {
                "###",
                "#k ",
                "####"
        };
        String[] simpleNoExit = new String[] {
                "###",
                "#k#",
                "###"
        };

        String[] noExit = new String[]{
                "########",
                "# # ## #",
                "# #k#  #",
                "# # # ##",
                "# # #  #",
                "#     ##",
                "########"
        };
        String[] bigMazeExit = new String[]{
                "########",
                "# # ####",
                "# #k#   ",
                "# # # ##",
                "# # # ##",
                "#      #",
                "########"
        };
        String[] nonRettangolare = new String[]{
                "#########",
                "#k        #",
                "###########"

        };
        System.out.println(hasExit(nonRettangolare));
    }

    public static boolean hasExit(String[] maze) {
        char[][] labirinto = creaLabirinto(maze);
        int[][] direzioni = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Nodo> coda = new LinkedList<>();
        int[] posizione = trovaKate(labirinto);

        boolean[][] posizioniVisitate = new boolean[maze.length][];
        for (int i = 0; i < maze.length; i++) {
            posizioniVisitate[i] = new boolean[labirinto[i].length];
        }

        coda.add(new Nodo(posizione[0], posizione[1]));
        posizioniVisitate[posizione[0]][posizione[1]] = true;

        while (!coda.isEmpty()) {
            Nodo nodoAttuale = coda.poll();
            int maxX = maze.length, maxY = labirinto[nodoAttuale.getX()].length;
            if (nodoAttuale.getX() == 0 || nodoAttuale.getX() == maxX - 1 || nodoAttuale.getY() == maxY - 1 || nodoAttuale.getY() == 0) return true;
            for (int[] direzione : direzioni) {
                int x = nodoAttuale.getX() + direzione[0];
                int y = nodoAttuale.getY() + direzione[1];
                System.out.println("Sto per controllare:  " + x + ", " + y);

                if (x < 0 || x >= labirinto.length || y < 0 || y >= labirinto[x].length) return true;
                if (labirinto[x][y] == ' ' && !posizioniVisitate[x][y]) {
                    coda.add(new Nodo(x, y));
                    posizioniVisitate[x][y] = true;
                }
            }
        }
        return false;
    }

    public static char[][] creaLabirinto(String[] labirinto) {
        char[][] labChar = new char[labirinto.length][0];
        for (int i = 0; i < labirinto.length; i++) {
            labChar[i] = labirinto[i].toCharArray();
        }
        return labChar;
    }

    public static int[] trovaKate(char[][] labirinto) {
        int contoKate = 0;
        int[] kate = new int[2];
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                if (labirinto[i][j] == 'k') {
                    contoKate++;
                    kate[0] = i;
                    kate[1] = j;
                }
            }
        }
        if (contoKate > 1 || contoKate == 0) throw new RuntimeException();
        return kate;
    }
}
class Nodo{
    int x, y;
    public Nodo(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){ return x;}
    public int getY(){ return y;}
}
