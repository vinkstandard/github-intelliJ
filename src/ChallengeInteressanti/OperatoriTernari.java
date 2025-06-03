package ChallengeInteressanti;

public class OperatoriTernari {
    public static void main(String[] args) {

//         la sintassi è questa: "condizione ? valore_se_vero : valore_se_falso;"
        int a = 10;
        int b = 5;
        int max = (a > b) ? a : b;
        System.out.println("Il massimo è: " + max);  // Stampa: Il massimo è: 10


//        può essere usato anche per stringhe o boolean:

        int voto = 75;
        String risultato = (voto >= 60) ? "Promosso" : "Bocciato";
        System.out.println(risultato);  // Promosso


        System.out.println("--------ESERCIZI--------");
        System.out.println("ESERCIZIO 1: " + 5 + " " + checkParita(6));
        System.out.println("ESERCIZIO 2: Prezzo base(" + 100 + ") Prezzo totale: " + getPrezzoFinale(100, false));
        System.out.println("ESERCIZIO 3: Una persona di "  + 18 + " anni, è " + stampaAdulto(18));


    }

    public static String checkParita(int numero) {
//        Esercizio 1:
//        Scrivi un'istruzione ternaria che assegna a una variabile parita la stringa "pari" se un numero n è pari, altrimenti "dispari".
        return (numero % 2 == 0) ? "E' pari" : "E' dispari";

    }

    public static double getPrezzoFinale(double prezzoBase, boolean isPremium) {
//        Esercizio 2:
//        Usa l'operatore ternario per assegnare a prezzoFinale il valore di prezzoBase scontato del 10% se il cliente è premium
//        (isPremium == true), altrimenti il prezzo pieno.
        return (isPremium) ? prezzoBase - ((prezzoBase * 10) / 100) : prezzoBase;
    }

    public static String stampaAdulto(int eta){
//        Esercizio 3:
//        Scrivi un'istruzione che stampa "Adulta" se età è maggiore o uguale a 18, altrimenti "Minorenne".
        return (eta >= 18) ? "adulta" : "minorenne";
    }
}
