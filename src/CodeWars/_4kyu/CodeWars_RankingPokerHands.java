package CodeWars._4kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeWars_RankingPokerHands {
    public static void main(String[] args) {

        // https://www.codewars.com/kata/5739174624fc28e188000465/train/java


        PokerHand manoCoppie = new PokerHand("2H 4H 6H 5H 2H");
        // System.out.println(mano1.compareWith(new PokerHand("KS AS TS QS JS")));
        System.out.println(manoCoppie.getValoreMano());


    }
}

class PokerHand {
    public enum Result { TIE, WIN, LOSS }
    public enum tabellaValori{ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, FOUR_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, STRAIGHT_FLUSH, ROYAL_FLUSH}

    private String[] carte = new String[5];
    private int valoreNumerico;
    private String valoreMano;
    PokerHand(String hand) {
        String[] split = hand.split(" ");
        System.arraycopy(split, 0, carte, 0, 5);
        valoreNumerico = calcolaValoreNumerico(carte);
        valoreMano = String.valueOf(calcolaValoreMano(carte));
    }




    public String[] getCarte(){
        return this.carte;
    }
    public int calcolaValoreNumerico(String[] carte){
        int valore = 0;
        for(String carta : carte){
            switch(carta.charAt(0)){
                case 'J': valore+= 11; break;
                case 'Q': valore+= 12; break;
                case 'K': valore+= 13; break;
                case 'A': valore+= 14; break;
                default: valore += Character.getNumericValue(carta.charAt(0));
            }
        }
        return valore;
    }
    public tabellaValori calcolaValoreMano(String[] carte){
//    S(pades), H(earts), D(iamonds), C(lubs)

        String semi = String.join("", carte).replaceAll("[^SHDC]" , "");
        String numeri = String.join("", carte).replaceAll("[SHDC]" , "");



        // caso coppie (one pair, two pair, three, four, e full house
        boolean[] coppie = new boolean[2];
        List<Character> controllati = new ArrayList<>();

        for(char numero : numeri.toCharArray()){
            if(!controllati.contains(numero)) {
                switch (numeri.replaceAll("" + numero, "").length()) {
                    case 3 -> {
                        if (coppie[0]) return tabellaValori.TWO_PAIR;
                        controllati.add(numero);
                        coppie[0] = true;
                    }
                    case 2 -> {
                        controllati.add(numero);
                        coppie[1] = true;
                    }
                }
            }
        }
        if(coppie[0] && coppie[1]) return tabellaValori.FULL_HOUSE;
        if(coppie[0]) return tabellaValori.ONE_PAIR;
        if(coppie[1]) return tabellaValori.THREE_OF_A_KIND;


        // caso straight, caso flush, e caso straight-flush e royal-flush








        return tabellaValori.FLUSH;
    }
    public String getValoreMano(){
        return valoreMano;
    }


    public int getValoreNumericoMano() {
        return valoreNumerico;
    }

    public Result compareWith(PokerHand hand) {
        return Result.TIE;
    }
}