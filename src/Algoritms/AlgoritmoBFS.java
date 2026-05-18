package Algoritms;

import java.util.LinkedList;
import java.util.Queue;

public class AlgoritmoBFS {
    public static void main(String[] args) {
        // https://en.wikipedia.org/wiki/Breadth-first_search

        // 1 muro, 0 strada
        char[][] labirintoConUscita = {
                {'—', '—', '—', '—', '—', '—', '—', '—', '—', '—', '—'},
                {'P', '0', '|', '0', '0', '0', '0', '0', '|', '0', '|'},
                {'|', '0', '|', '0', '|', '—', '|', '0', '|', '0', '|'},
                {'|', '0', '0', '0', '|', '0', '|', '0', '0', '0', '|'},
                {'|', '—', '|', '0', '|', '0', '|', '—', '|', '0', '|'},
                {'|', '0', '0', '0', '0', '0', '0', '0', '|', '0', '0'},
                {'—', '—', '—', '—', '—', '—', '—', '—', '—', '—', '—'}
        };

        stampaLabirinto(labirintoConUscita);
        Nodo nodo1 = trovaUscita(new Nodo(1, 0), labirintoConUscita);
        if(nodo1 != null){
            System.out.println("Uscita trovata in posizione: X:" + nodo1.getX() + " | Y:" + nodo1.getY());
        }
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
        int rigo = labirinto.length, colonna = labirinto[0].length;
        boolean[][] visitati = new boolean[rigo][colonna];
        int[][] direzioni = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        coda.add(puntoDiPartenza);
        visitati[puntoDiPartenza.getX()][puntoDiPartenza.getY()] = true;

        while (!coda.isEmpty()) {
            Nodo nodoAttuale = coda.poll();
            int x = nodoAttuale.getX(), y = nodoAttuale.getY();

            if (labirinto[x][y] != 'P') {
                if (x == 0 || x == rigo - 1 || y == 0 || y == colonna - 1) {
                    System.out.println("----------Uscita trovata!----------");
                    stampaLabirinto(labirinto);
                    return nodoAttuale;
                }
            }
            for(int[] direzione : direzioni){
                int nuovoX = x + direzione[0], nuovoY = y + direzione[1];

                // check out of bounds
                if(nuovoX < 0 || nuovoX >= rigo || nuovoY < 0 || nuovoY >= colonna) continue;
                if(labirinto[nuovoX][nuovoY] == '0' && !visitati[nuovoX][nuovoY]){
                    // ci spostiamo
                    visitati[nuovoX][nuovoY] = true;
                    coda.add(new Nodo(nuovoX, nuovoY));
                    labirinto[nuovoX][nuovoY] = '1';
                    stampaLabirinto(labirinto);
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

}
