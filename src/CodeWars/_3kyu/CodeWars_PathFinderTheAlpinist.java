package CodeWars._3kyu;

import java.util.Arrays;
import java.util.List;

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
        char[][] labirinto = creaLabirinto(maze);
        System.out.println(Arrays.deepToString(labirinto));
        return -1;
    }
    static char[][] creaLabirinto(String labirinto){
        String[] splittato = labirinto.split("\n");
        char[][] labArray = new char[splittato.length][splittato.length];
        int n = 0;
        for(String rigo : splittato){
            labArray[n++] = rigo.toCharArray();
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


