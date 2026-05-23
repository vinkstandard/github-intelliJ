package CodeWars._4kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeWars_RankingPokerHands {
    public static void main(String[] args) {

        // https://www.codewars.com/kata/5739174624fc28e188000465/train/java
        // System.out.println(new PokerHand("2H 3H 4H 5H 6H").compareWith(new PokerHand("KS AS TS QS JS")));
        // System.out.println(new PokerHand("AS AH 2H AD AC").compareWith(new PokerHand("JS JD JC JH 3D"))); // win, l'avversario ha un tris più basso
        System.out.println(new PokerHand("JH 8S TH AH QH").compareWith(new PokerHand("TS KS 5S 9S AC"))); // loss
    }
}

class PokerHand {
    public enum Result {TIE, WIN, LOSS}

    public enum tabellaValori {NOTHING, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH}
    private String[] carte = new String[5];

    PokerHand(String hand) {
        String[] split = hand.split(" ");
        System.arraycopy(split, 0, carte, 0, 5);
    }

    public Result compareWith(PokerHand hand) {
        tabellaValori valoreGiocatore1 = calcolaValoreMano(carte), valoreGiocatore2 = hand.calcolaValoreMano(hand.getCarte());
        int punteggioGiocatore1 = valoreGiocatore1.ordinal(), punteggioGiocatore2 = valoreGiocatore2.ordinal();
        // combinazioni diverse
        if (punteggioGiocatore1 != punteggioGiocatore2) {
            if (punteggioGiocatore1 > punteggioGiocatore2) {
                return Result.WIN;
            } else {
                return Result.LOSS;
            }
        } else {
            // confronta le due mani ordinate in ordine decrescente. se il giocatore 1 ha la prima carta uguale alla prima dell'avversario, si procede a controllare le seconde e cosi via
            List<String> carteGiocatore = ordinaCarte(Arrays.asList(carte));
            List<String> carteAvversario = ordinaCarte(Arrays.asList(hand.carte));
            for (int i = carteGiocatore.size() - 1; i >= 0; i--) {
                int valoreCartaGiocatore = getPesoCarta(carteGiocatore.get(i)), valoreCartaAvversario = getPesoCarta(carteAvversario.get(i)), comparazione = Integer.compare(valoreCartaGiocatore, valoreCartaAvversario);
                if (comparazione > 0) {
                    return Result.WIN;
                } else if (comparazione < 0) {
                    return Result.LOSS;
                }
            }

        }
        return Result.TIE;
    }

    public String[] getCarte() {
        return this.carte;
    }

    public tabellaValori calcolaValoreMano(String[] carte) {

        List<String> carteOrdinate = ordinaCarte(Arrays.asList(carte));
        String semi = String.join("", carteOrdinate).replaceAll("[^SHDC]", "");
        String numeri = String.join("", carteOrdinate).replaceAll("[SHDC]", "");

        // caso coppie (one pair, two pair, three, four, e full house
        boolean[] coppie = new boolean[2];
        List<Character> controllati = new ArrayList<>();

        for (char numero : numeri.toCharArray()) {
            if (!controllati.contains(numero)) {
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
                    case 1 -> {
                        return tabellaValori.FOUR_OF_A_KIND;
                    }
                }
            }
        }
        if (coppie[0] && coppie[1]) return tabellaValori.FULL_HOUSE;
        if (coppie[0]) return tabellaValori.ONE_PAIR;
        if (coppie[1]) return tabellaValori.THREE_OF_A_KIND;

        // caso straight, caso flush, e caso straight-flush e royal-flush
        boolean straight = false, flush = false;
        for (int i = 1; i < semi.length(); i++) {
            // flush
            char c = semi.charAt(i);
            if (semi.replaceAll(c + "", "").isEmpty()) {
                flush = true;
                break;
            }
        }
        List<String> numeriSplit = Arrays.asList(numeri.split(""));
        int inizioNum = getPesoCarta(numeriSplit.get(0));
        for (int i = 1; i < numeriSplit.size(); i++) {
            int numeroAttuale = getPesoCarta(numeriSplit.get(i));
            if (numeroAttuale == (inizioNum + 1)) {
                inizioNum = numeroAttuale;
                straight = true;
                continue;
            }
            straight = false;
            break;
        }
        if (straight && flush && numeri.contains("A")) return tabellaValori.ROYAL_FLUSH;
        if (straight && flush) return tabellaValori.STRAIGHT_FLUSH;
        if (straight) return tabellaValori.STRAIGHT;
        if (flush) return tabellaValori.FLUSH;
        return tabellaValori.NOTHING;
    }

    public List<String> ordinaCarte(List<String> carte) {
        List<String> listaOrdinata = new ArrayList<>(carte);
        listaOrdinata.sort((carta1, carta2) -> {
            int valore1 = getPesoCarta(carta1);
            int valore2 = getPesoCarta(carta2);
            return Integer.compare(valore1, valore2);
        });
        return listaOrdinata;
    }

    private int getPesoCarta(String carta) {
        char valore = carta.charAt(0);
        return switch (valore) {
            case 'T' -> 10;
            case 'J' -> 11;
            case 'Q' -> 12;
            case 'K' -> 13;
            case 'A' -> 14;
            default -> Character.getNumericValue(valore);
        };
    }
}