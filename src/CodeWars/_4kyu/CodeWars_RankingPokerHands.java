package CodeWars._4kyu;

import java.util.Arrays;

public class CodeWars_RankingPokerHands {
    public static void main(String[] args) {

        // https://www.codewars.com/kata/5739174624fc28e188000465/train/java


        PokerHand mano1 = new PokerHand("2H 3H 4H 5H 6H");
        // System.out.println(mano1.compareWith(new PokerHand("KS AS TS QS JS")));
         System.out.println(Arrays.toString(mano1.getCarte()));
        System.out.println(mano1.getValoreNumericoMano());
        System.out.println(mano1.getValoreMano());


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

        StringBuilder parteNumerica = new StringBuilder(), parteLettere = new StringBuilder();

        for(int i = 0; i < carte.length; i++){
            parteNumerica.append(carte[i].replaceAll("[A-Za-z]" , ""));
            parteLettere.append(carte[i].replaceAll("[0-9]" , ""));
        }
        System.out.println(parteLettere);
        System.out.println(parteNumerica);


        // caso coppie (one pair, two pair, three, four, e full house


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