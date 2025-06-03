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
        System.out.println(5 + " " + checkParita(5));


    }

    public static String checkParita(int numero) {
//        Esercizio 1:
//        Scrivi un'istruzione ternaria che assegna a una variabile parita la stringa "pari" se un numero n è pari, altrimenti "dispari".
        return (numero % 2 == 0) ? "E' pari" : "E' dispari";

    }
}
