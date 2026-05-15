package CodeWars._3kyu;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CodeWars_PathFinderTheAlpinist {
    public static void main(String[] args) {

        // https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
        // https://www.codewars.com/kata/576986639772456f6f00030c/train/java

        List<String> labirinti = List.of(
                "000\n"+ "000\n"+ "000",
                "0707\n"+ "7070\n"+ "0707\n"+ "7070",
                "000000\n"+ "000000\n"+ "000000\n"+ "000010\n"+ "000109\n"+ "001010");
        for(String labirinto : labirinti){
            System.out.println(pathFinder(labirinto));
        }

    }
    static int pathFinder(String maze) {
        int[][] labirinto = creaLabirinto(maze);
        int n = labirinto.length;
        int[][] distanzeMinime = new int[n][n];
        for (int i = 0; i < distanzeMinime.length; i++) {
            Arrays.fill(distanzeMinime[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Nodo> pq = new PriorityQueue<>();
        pq.add(new Nodo(0,0,0));

        int[][] direzioni = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!pq.isEmpty()){
            Nodo nodoAttuale = pq.poll();
            if(nodoAttuale.getX() == n - 1 && nodoAttuale.getY() == n - 1) return nodoAttuale.getValore();

            int x = nodoAttuale.getX(), y = nodoAttuale.getY();
            for(int[] direzione : direzioni){
                if(x + direzione[0] == n || x + direzione[0] < 0 || y + direzione[1] == n || y + direzione[1] < 0) continue; // check per non andare out of bounds
                int nuovoX = x + direzione[0], nuovoY = y + direzione[1];
                int altitudineAttuale = labirinto[x][y], altitudineVicino = labirinto[nuovoX][nuovoY];
                int costoPasso = Math.abs(altitudineAttuale - altitudineVicino);
                int nuovaFaticaTotale = nodoAttuale.getValore() + costoPasso;
                if(nuovaFaticaTotale < distanzeMinime[nuovoX][nuovoY]){
                    distanzeMinime[nuovoX][nuovoY] = nuovaFaticaTotale;
                    pq.add(new Nodo(nuovoX, nuovoY, nuovaFaticaTotale));
                }
            }
        }
        return -1;
    }

    static int[][] creaLabirinto(String labirinto){
        int n = labirinto.split("\n").length;
        int[][] labArray = new int[n][n];
        for(int rigo = 0; rigo < n; rigo++){
            for(int colonna = 0; colonna < n; colonna++){
                labArray[rigo][colonna] = Character.getNumericValue(labirinto.split("\n")[rigo].charAt(colonna));
            }
        }
        return labArray;
    }
}

class Nodo implements Comparable<Nodo>{
    private int x, y, valore;
    public Nodo(int x, int y, int valore){
        this.x = x;
        this.y = y;
        this.valore = valore;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }
    public int getValore(){ return valore; }

    @Override
    public int compareTo(Nodo altroNodo){
        return Integer.compare(this.valore, altroNodo.getValore());
    }
}
