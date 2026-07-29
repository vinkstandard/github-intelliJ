package CodeWars._4kyu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CodeWars_EscapeTheMaze {
    public static void main(String[] args) {

        // https://www.codewars.com/kata/5877027d885d4f6144000404/train/java

        List<char[][]> labirinti = new ArrayList<>();
//        labirinti.add(new char[][] {
//                "# #".toCharArray(),
//                " > ".toCharArray(),
//                "# #".toCharArray()
//        });
        labirinti.add(new char[][] {
                "###########".toCharArray(),
                "#>        #".toCharArray(),
                "######### #".toCharArray()
        });
//        labirinti.add(new char[][] {
//                "# #########".toCharArray(),
//                "#        >#".toCharArray(),
//                "###########".toCharArray()
//        });
        for(char[][] labirinto : labirinti){
            System.out.println("-----------Inizio lab--------------");
            escape(labirinto);

        }

    }
    public static List<Character> escape(char[][] maze) {
        Node nodoPartenza = getNodoPartenza(maze);
        System.out.println("partenza: " + nodoPartenza.getX() + ", " + nodoPartenza.getY());
        int rigo = maze.length, colonna = maze[0].length;
        Queue<Node> coda = new LinkedList<>();
        coda.add(nodoPartenza);
        boolean[][] posizioniVisitate = new boolean[rigo][colonna];
        posizioniVisitate[nodoPartenza.getX()][nodoPartenza.getY()] = true;
        int[][] direzioni = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        List<Node> exitRoute = new ArrayList<>();
        List<Character> listaReturn = new ArrayList<>();

        while(!coda.isEmpty()){
            Node nodoAttuale = coda.poll();
            int x = nodoAttuale.getX(), y = nodoAttuale.getY();
            if(x == rigo - 1 || x == 0 || y == colonna - 1 || y == 0){
                System.out.println("WIN - uscita trovata in pos: " + x + ", " + y);
                // inizio backtracking
                while(nodoAttuale != null){
                    exitRoute.add(nodoAttuale);
                    nodoAttuale = nodoAttuale.getParente();
                }
                break;
            }
            for(int indiceDirezione = 0; indiceDirezione < direzioni.length; indiceDirezione++){
                int nuovaX = x + direzioni[indiceDirezione][0], nuovaY = y + direzioni[indiceDirezione][1];
                if(nuovaX >= rigo || nuovaX < 0 || nuovaY >= colonna || nuovaY < 0) continue;
                if(maze[nuovaX][nuovaY] == ' ' && !posizioniVisitate[nuovaX][nuovaY]){
                    char simbolo = switch (indiceDirezione) {
                        case 0 -> '>';
                        case 1 -> '<';
                        case 2 -> 'v';
                        case 3 -> '^';
                        default -> '?';
                    };
                    Node nuovoNodo = new Node(nuovaX, nuovaY, nodoAttuale, simbolo);
                    posizioniVisitate[nuovaX][nuovaY] = true;
                    coda.add(nuovoNodo);
                }
            }
        }
        char orientamento = nodoPartenza.getOrientamentoAttuale();
        List<Character> orientamenti = List.of('^', '>', 'v', '<');
        for(int i = exitRoute.size() - 2; i >= 0; i--){
            Node nodoUscita = exitRoute.get(i);
            System.out.println(nodoUscita.getX() + "," + nodoUscita.getY() + " OrientamentoAttuale: " + orientamento +  " | OrientamentoUscita: [" + nodoUscita.getOrientamentoAttuale() + "]");
            int differenza =  orientamenti.indexOf(nodoUscita.getOrientamentoAttuale()) - orientamenti.indexOf(orientamento);
            if(differenza == 0){
                listaReturn.add('F');
            }
            if(differenza == 1 || differenza == -3){
                listaReturn.add('R');
                listaReturn.add('F');
            }
            if(differenza == 2 || differenza == -2){
                listaReturn.add('B');
                listaReturn.add('F');
            }
            if(differenza == 3 || differenza == -1){
                listaReturn.add('L');
                listaReturn.add('F');
            }

            orientamento = nodoUscita.getOrientamentoAttuale();
        }

        printDebug(maze);

        System.out.println(listaReturn);
        return null;
    }

    public static Node getNodoPartenza(char[][] maze){
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                if(maze[i][j] == '<' || maze[i][j] == '>' || maze[i][j] == '^' || maze[i][j] == 'v'){
                    return new Node(i,j, maze[i][j]);
                }
            }
        }
        throw new RuntimeException();
    }

    public static void printDebug(char[][] labirinto){
        for(int i = 0; i < labirinto.length; i++){
            for(int j = 0; j < labirinto[0].length; j++){
                if(labirinto[i][j] == ' '){
                    System.out.print(". ");
                    continue;
                }
                System.out.print(labirinto[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Node{
    private int x, y;
    private Node parente;
    private char orientamentoAttuale;
    public Node(int x, int y, char orientamentoAttuale){
        this.x = x;
        this.y = y;
        this.orientamentoAttuale = orientamentoAttuale;
    }
    public Node(int x, int y, Node parente, char orientamentoAttuale){
        this.x = x;
        this.y = y;
        this.parente = parente;
        this.orientamentoAttuale = orientamentoAttuale;
    }
    public int getX(){ return x;}
    public int getY(){ return y;}
    public char getOrientamentoAttuale() {return orientamentoAttuale;}
    public Node getParente(){ return parente;}

}


