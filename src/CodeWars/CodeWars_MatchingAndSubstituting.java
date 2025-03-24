package CodeWars;

import java.util.HashMap;

public class CodeWars_MatchingAndSubstituting {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/59de1e2fe50813a046000124/train/java
//        I got lots of files beginning like this:
//        Program title: Primes
//        Author: Kern
//        Corporation: Gold
//        Phone: +1-503-555-0091
//        Date: Tues April 9, 2005
//        Version: 6.7
//        Level: Alpha
//
//        Here we will work with strings like the string data above and not with files.
//        The function change(s, prog, version) given:

//        s=data, prog="Ladder" , version="1.1" will return:
//        "Program: Ladder Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 1.1"
//
//        Rules:
//        The date should always be "2019-01-01".
//        The author should always be "g964".
//        Replace the current "Program Title" with the prog argument supplied to your function.
//        Also remove "Title", so in the example case "Program Title: Primes" becomes "Program: Ladder".
//
//        Remove the lines containing "Corporation" and "Level" completely.
//        Phone numbers and versions must be in valid formats.
//        A valid version in the input string data is one or more digits followed by a dot,
//        followed by one or more digits. So 0.6, 5.4, 14.275 and 1.99 are all valid, but versions like .6, 5, 14.2.7 and 1.9.9 are invalid.
//
//        A valid input phone format is +1-xxx-xxx-xxxx, where each x is a digit.
//        If the phone or version format is not valid, return "ERROR: VERSION or PHONE".
//        If the version format is valid and the version is anything other than 2.0,
//        replace it with the version parameter supplied to your function. If it’s 2.0, don’t modify it.
//
//        If the phone number is valid, replace it with "+1-503-555-0090"

        String s = "Program title: Primes\n" +
                "Author: Kern\n" +
                "Corporation: Gold\n" +
                "Phone: +1-503-555-0091\n" +
                "Date: Tues April 9, 2005\n" +
                "Version: 6.7\n" +
                "Level: Alpha";
//        String s="Program title: Primes\n" +
//                "Author: Kern\n" +
//                "Corporation: Gold\n" +
//                "Phone: +1-503-555-0091\n" +
//                "Date: Tues April 9, 2005\n" +
//                "Version: 6.7\n" +
//                "Level: Alpha";


        String prog = "Ladder";
        String version = "1.1";
        System.out.println(change(s,prog,version));

    }
    public static String change(String s, String prog, String version) {

        // stampa debug
        System.out.println(s);
        // rimuovi corporation e level
        // il formato corretto per le versioni è num(infinitoNumeroDiNumeri) poi un punto "." e poi num(infinitoNumeroDiNumeri) STOP
        // se la versione è in formato corretto, ed è "2.0" allora non cambiarla con quella fornita dal metodo

        // il formato corretto per il numero di cell è "+1-xxx-xxx-xxxx" dove x è per forza un numero
        // se il numero o la versione sono in formato sbagliato, quindi non sono validi, ritorna :ERROR: VERSION or PHONE

        String dataCostante = "2019-01-01";
        String autoreCostante = "g964";

        HashMap<String, String> mappa = new HashMap<>();
        String[] data = s.split("\n");
        for (String st : data) {
            String chiave = "";
            // prendo la chiave
            for (int i = 0; i < st.length(); i++) {
                if (st.charAt(i) == ':') {
                    break;
                }
                chiave += st.charAt(i);
            }
            // level e corporation li skippiamo, per gli altri due invece useremo le costanti
            if (chiave.equals("Level") || chiave.equals("Corporation") || chiave.equals("Date") || chiave.equals("Author")) {
                continue;
            }
            // rimuoviamo da st la chiave e prendiamo il resto come "valore" per poi inserirli entrambi nella mappa
            st = st.replace(chiave, "").replaceAll(" ", "").replaceAll(":", "").trim();

            // check per vedere se il numero di cell è valido
            if(chiave.equals("Phone")){
                System.out.println(st);
                if(!st.matches("^\\+1-\\d{3}-\\d{3}-\\d{4}$")){
                    return "ERROR: VERSION or PHONE";
                }
            }
            else if(chiave.equals("Version")){
                if(!st.matches("^\\d+\\.\\d+$")){
                    return "ERROR: VERSION or PHONE";
                }
            }



            mappa.put(chiave, st);
        }
        System.out.println(mappa);

        // check per vedere se il numero di cell è un numero valido






        return null;
    }
}
