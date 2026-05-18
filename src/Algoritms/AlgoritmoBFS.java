package Algoritms;

import java.util.LinkedList;
import java.util.Queue;

public class AlgoritmoBFS {
    public static void main(String[] args) {
        // https://en.wikipedia.org/wiki/Breadth-first_search

        // 1 muro, 0 strada
        char[][] labirintoConUscita = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'0', '0', '|', '0', '0', '0', '0', '0', '|', '0', '|'},
                {'|', '0', '|', '0', '|', '-', '|', '0', '|', '0', '|'},
                {'|', '0', '0', '0', '|', '0', '|', '0', '0', '0', '|'},
                {'|', '-', '|', '0', '|', '0', '|', '-', '|', '0', '|'},
                {'|', '0', '0', '0', '0', '0', '0', '0', '|', '0', '0'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };

        stampaLabirinto(labirintoConUscita);
        Nodo nodo1 = trovaUscita(new Nodo(1, 0), labirintoConUscita);
        nodo1.stampaNodo();
    }

    public static void stampaLabirinto(char[][] labirinto) {
        for (char[] chars : labirinto) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();

        }
    }

    static Nodo trovaUscita(Nodo puntoDiPartenza, char[][] labirinto) {

        Queue<Nodo> coda = new LinkedList<>();
        boolean[][] visitati = new boolean[labirinto.length][labirinto[0].length];
        int[][] direzioni = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        coda.add(puntoDiPartenza);
        visitati[puntoDiPartenza.getX()][puntoDiPartenza.getY()] = true;


        while (!coda.isEmpty()) {
            Nodo nodoAttuale = coda.poll();
            int x = nodoAttuale.getX(), y = nodoAttuale.getY();

            if (x != puntoDiPartenza.getX() || y != puntoDiPartenza.getY()) {
                if (x == 0 || x == labirinto.length - 1 || y == 0 || y == labirinto[0].length - 1) {
                    return nodoAttuale;
                }
            }
            for(int[] direzione : direzioni){
                int nuovoX = x + direzione[0], nuovoY = y + direzione[1];

                // check out of bounds
                if(nuovoX < 0 || nuovoX >= labirinto.length || nuovoY < 0 || nuovoY >= labirinto[0].length) continue;
                if(labirinto[nuovoX][nuovoY] == '0' && !visitati[nuovoX][nuovoY]){
                    // ci spostiamo
                    visitati[nuovoX][nuovoY] = true;
                    coda.add(new Nodo(nuovoX, nuovoY));
                }

            }

        }
        return null;
    }

}

class Nodo {
    int x, y;
    public Nodo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() { return x; }
    public int getY() { return y; }
    public void stampaNodo(){
        System.out.println("X: " + this.x + " | Y: " + this.y);
    }
}
