package AdventOfCode2025;

import java.io.*;
import java.util.*;

public class Day7 {
    static int totaleParte1 = 0;
    public static void main(String[] args) throws IOException {


        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2025\\day7.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        char[][] matrice = new char[righe.size()][righe.getFirst().length()];
        for (int i = 0; i < righe.size(); i++) {
            matrice[i] = righe.get(i).toCharArray();
        }
        matrice[1][matrice[0].length / 2] = '|'; // sotto la S


        calcolaParte1(matrice);
        System.out.println("Risultato parte 1: " + totaleParte1 / 2);

        stampaMatrice(matrice);

    }

    public static void calcolaParte1(char[][] matrice){
        int altezzaAttuale = 1;
        while(altezzaAttuale < matrice.length){
            List<int[]> lista = trovaRaggi(matrice, altezzaAttuale);
            if(!lista.isEmpty()){
                for(int[] posizioneRaggio : lista){
                    estendiRaggio(matrice, posizioneRaggio);
                }
            }
            altezzaAttuale++;
        }

    }
    public static void estendiRaggio(char[][] matrice, int[] posizioneRaggio){
        int x = posizioneRaggio[0] + 1;


        if(x >= 0 && x < matrice.length){
            if(matrice[x][posizioneRaggio[1]] == '.' || matrice[x][posizioneRaggio[1]] == '|' ){
                System.out.println("Raggio esteso in: " + x + ", " + posizioneRaggio[1]);
                matrice[x][posizioneRaggio[1]] = '|';
            } else {
                // split a sx
                int sin = posizioneRaggio[1] - 1;
                if(sin >= 0 && sin < matrice[0].length){
                    if(matrice[x][sin] == '.' || matrice[x][sin] == '|'){
                        matrice[x][sin] = '|';
                        totaleParte1++;
                    }
                }
                // split a dx
                int dest = posizioneRaggio[1] + 1;
                if(dest < matrice[0].length){
                    if(matrice[x][dest] == '.' || matrice[x][dest] == '|'){
                        matrice[x][dest] = '|';
                        totaleParte1++;
                    }
                }
            }
        }
    }

    public static List<int[]> trovaRaggi(char[][] matrice, int altezzaAttuale){
        List<int[]> posizioni = new ArrayList<>();
        for(int j = 0; j < matrice[0].length; j++){
            if(matrice[altezzaAttuale][j] == '|') posizioni.add(new int[]{altezzaAttuale, j});
        }
        return posizioni;
    }

    public static void stampaMatrice(char[][] matrice){
        final String VERDE = "\u001B[32m";
        final String RESET = "\u001B[0m";
        final String BLU = "\u001B[34m";
        final String GIALLO = "\u001B[1;33m";

        for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[0].length; j++){
                char elemento = matrice[i][j];
                String colore = "";
                if(elemento == '^') colore = BLU;
                if(elemento == '|') colore = GIALLO;
                if(elemento == '.') colore = VERDE;
                System.out.print(colore + elemento + RESET + " ");
            }
            System.out.println();
        }
    }
}
