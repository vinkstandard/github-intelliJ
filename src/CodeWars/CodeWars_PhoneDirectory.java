package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class CodeWars_PhoneDirectory {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/56baeae7022c16dd7400086e
//        John keeps a backup of his old personal phone book as a text file. On each line of the file he can find the phone number (formated as +X-abc-def-ghij where X stands for one or two digits), the corresponding name between < and > and the address.
//
//        Unfortunately everything is mixed, things are not always in the same order; parts of lines are cluttered with non-alpha-numeric characters (except inside phone number and name).
//
//        Examples of John's phone book lines:
//        "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n"
//        " 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
//        "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n"
//
//        Could you help John with a program that, given the lines of his phone book and a phone number num returns a string for this number :
//        "Phone => num, Name => name, Address => adress"
//        Examples:
//        s = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
//
//        phone(s, "1-541-754-3010") should return "Phone => 1-541-754-3010, Name => J Steeve, Address => 156 Alphand St."
//        It can happen that there are many people for a phone number num, then return : "Error => Too many people: num"
//        or it can happen that the number num is not in the phone book, in that case return: "Error => Not found: num"
//
//        Notes
//        Codewars stdout doesn't print part of a string when between < and >
//        You can see other examples in the test cases.
//        JavaScript random tests completed by @matt c

        String rubrica =
                "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n" +
                " 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n" +
                "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n" +
                " :+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n" +
                "+1-741-984-3090 <Peter Reedgrave> _Chicago\n" +
                " :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n" +
                "+1-111-544-8973 <Peter Pan> LA\n" +
                " +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n" +
                "<Peter Gone> LA ?+1-121-544-8974 \n" +
                " <R Steell> Quora Street AB-47209 +1-481-512-2222\n" +
                "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n" +
                " <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n" +
                "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n" +
                " <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n" +
                "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n" +
                "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n" +
                " <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n" +
                "+1-099-500-8000 <Peter Crush> Labrador Bd.\n" +
                " +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n" +
                "<P Salinge> Main Street, +1-098-512-2222, Denve";
        String num = "1-098-512-2222";

        System.out.println(phone(rubrica,num));
    }
    public static  String phone(String strng, String num) {

        String[] righeNonModificate = strng.split("\n");
        ArrayList<String> righe = new ArrayList<>();

        for(String riga : righeNonModificate){
            StringBuilder sb = new StringBuilder();
            String[]splittato = riga.split(" ");

            for(String s : splittato){
                if(s.length() > 1){
                    sb.append(s).append(" ");
                }
            }
            // aggiungiamo la linea a righe, rimuovendo però i caratteri inutili
            righe.add(sb.toString().replaceAll("[^a-zA-Z0-9.'_\\s-<>]", ""));
        }
        // stampa debug
        for(int i = 0; i < righeNonModificate.length; i++){
            System.out.println("NON MOD: " + righeNonModificate[i] + "\t\tMOD: " + righe.get(i));
        }
        ArrayList<String> nomi = new ArrayList<>();
        ArrayList<String> numeri = new ArrayList<>();
        for(int i = 0; i < righe.size(); i++){
            String s = righe.get(i);

            // prendo i numeri, li aggiungo alla lista, e poi li rimuovo dalla stringa originale
            String regXNumeri = "\\d+-\\d{3}-\\d{3}-\\d{4}";
            Pattern patternNums = Pattern.compile(regXNumeri);
            Matcher matcherNums = patternNums.matcher(s);
            while(matcherNums.find()){
                numeri.add(matcherNums.group());
                s = s.replaceAll("\\d+-\\d{3}-\\d{3}-\\d{4}", "");
            }

            // prendo i nomi e faccio lo stesso
            String regXNomi = "<\\s*([a-zA-Z' ]+)\\s*>";
            Pattern patternNomi = Pattern.compile(regXNomi);
            Matcher matcherNomi = patternNomi.matcher(s);
            while(matcherNomi.find()){
                nomi.add(matcherNomi.group());
                s = s.replaceAll("<\\s*([a-zA-Z' ]+)\\s*>", "");
            }

            // adesso aggiorno la lista con le modifiche
            righe.set(i, s);
        }

        // stampa debug
        System.out.println();
        for(String s : righe){
            System.out.println(s);
        }

        // adesso prendiamo gli indirizzi

        ArrayList<String> indirizzi = new ArrayList<>();
        for(String s : righe){
            StringBuilder indirizzo = new StringBuilder();
            String[] splittato = s.split(" ");
            for(String g : splittato){
                if(!g.contains(" ") && !g.isEmpty()){
                    indirizzo.append(g).append(" ");
                    System.out.println("APPESO: " + g);
                }
            }

            // alcuni hanno i trattini bassi invece che gli spazi, immagino di dover modificare la regex forse anche con i punti o le virgole.

            indirizzi.add(indirizzo.toString().replaceAll("_", " ").trim());
        }
        System.out.println();
        for(String s : indirizzi){
            System.out.println(s);
        }



        return null;
    }
}
