package CodeWars._6kyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CodeWars_PhoneWords {

    public static void main(String[] args) {


//        https://www.codewars.com/kata/635b8fa500fba2bef9189473
//        Given a string of numbers, you must perform a method in which you will translate this string into text, based on the below image:
//
//
//        For example if you get "22" return "b", if you get "222" you will return "c". If you get "2222" return "ca".
//
//        Further details:
//
//        0 is a space in the string.
//        1 is used to separate letters with the same number.
//        always transform the number to the letter with the maximum value, as long as it does not have a 1 in the middle. So, "777777" -->  "sq" and "7717777" --> "qs".
//        you cannot return digits.
//        Given a empty string, return empty string.
//        Return a lowercase string.
//        Examples:
//        "44 33 555555 666 0 44 666 9 0 2 777 33 0 999 666 88"  -->  "hello how are you"
//        "55282"                 -->  "kata"
//        "22266631339277717777"  -->  "codewars"
//        "66885551555"           -->  "null"
//        "833998"                -->  "text"
//        "000"                   -->  "   "


//        String str = "443355555566604466690277733099966688";
        String str = "443355555566604466690277733099966688";
//        System.out.println("(" + phoneWords(str) + ")\tExpected: (kata)");
        System.out.println("(" + phoneWords(str) + ")\tExpected: (hello how are you)");
    }

    public static String phoneWords(String str) {
// TODO: usa substring ffs

        ArrayList<String> combinazioni = new ArrayList<>();
        HashMap<Character, Integer> mappa = new HashMap<>();

        char[] numeri = str.toCharArray();
        char charAttuale = str.charAt(0);
        for (char c : numeri) {
            // nuovo carattere
            if (c != charAttuale) {
                combinazioni.add(charAttuale + "|" + mappa.get(charAttuale));
                mappa = new HashMap<>();
                System.out.println("NUOVA MAPPA CREATA");
            }
            if (!mappa.containsKey(c)) {
                mappa.put(c, 1);
                charAttuale = c;
            } else {
                mappa.put(c, mappa.get(c) + 1);

            }
        }
        // aggiungiamo l'ultima serie rimasta
        combinazioni.add(charAttuale + "|" + mappa.get(charAttuale));
        System.out.println(combinazioni);

        StringBuilder sb = new StringBuilder();
        for(String comb : combinazioni){
            String s = traduciNumeri(comb);
            System.out.println("APPESO: " + s);
            sb.append(s);
        }


        return sb.toString();
    }
    public static String traduciNumeri(String elemento){

// TODO: FIXA QUESTA
//        always transform the number to the letter with the maximum value,
//        as long as it does not have a 1 in the middle. So, "777777" -->  "sq" and "7717777" --> "qs".

        int letteraNum = Character.getNumericValue(elemento.charAt(0));
        int posizione = Character.getNumericValue(elemento.charAt(2));
        if(letteraNum == 0){
            return " "; // aggiungiamo lo spazio
        }
        if(letteraNum == 1){
            return ""; // nulla.
        }


        HashMap<Character, String> mappa = new HashMap<>();
        mappa.put('2', "abc");mappa.put('3', "def");mappa.put('4', "ghi");mappa.put('5', "jkl");
        mappa.put('6', "mno");mappa.put('7', "pqrs");mappa.put('8', "tuv");mappa.put('9', "wxyz");

        char lettera = (char)(letteraNum + '0');
        System.out.println("ELEMENTO: " + elemento + "\tPOSIZIONE: " +posizione + "\tLETTERANUM: " + letteraNum + "\tCARATTERE: " + lettera);

        if(posizione < mappa.get(lettera).length()){
            System.out.println("LETTERA: " + lettera);
            System.out.println("DA APPENDERE: " + mappa.get(lettera).charAt(posizione -1));
            return String.valueOf(mappa.get(lettera).charAt(posizione - 1));
        }




        return null;
    }

}
