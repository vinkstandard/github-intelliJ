package CodeWars._4kyu;

import java.util.List;

public class CodeWars_CodewarsStyleRankingSystem {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/51fda2d95d6efda45e00004e/train/java

        User utente = new User();
        List<Integer> test1 = List.of(-8, -7, -6, -5, -4, -8, 1, 1, 1, 1, 1, 2, 2, -1);
        test1.forEach(utente::incProgress);

        System.out.println("LIVELLO UTENTE FINALE: " + utente.rank + " | Resto progressi: " + utente.progress);
    }
}

class User {
    private static final List<Integer> RANKS = List.of(-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8);
    int rank = -8;
    int progress = 0;

    public void incProgress(int kataRank) {
        int indiceKata = RANKS.indexOf(kataRank);
        if (indiceKata == -1) throw new IllegalArgumentException();
        if (this.rank == 8) return;

        int indiceUtente = RANKS.indexOf(this.rank);
        int differenza = indiceKata - indiceUtente;

        int guadagno = 0;
        if (differenza == 0) guadagno = 3;
        if (differenza == -1) guadagno = 1;
        if (differenza > 0) guadagno = 10 * differenza * differenza;
        this.progress += guadagno;

        while (this.progress >= 100) {
            if (this.rank < 8) {
                indiceUtente++;
                this.rank = RANKS.get(indiceUtente);

                if (this.rank == 8) {
                    this.progress = 0;
                    break;
                }
                this.progress -= 100;
            }
        }
    }
}