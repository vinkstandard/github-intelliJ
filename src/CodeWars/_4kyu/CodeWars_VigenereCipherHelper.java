package CodeWars._4kyu;

import java.util.ArrayList;

public class CodeWars_VigenereCipherHelper {
    public static void main(String[] args) {
        String key = "password";
        String abc = "abcdefghijklmnopqrstuvwxyz";

        VigenereCipher cipher = new VigenereCipher(key, abc);

        String encoded = cipher.encode("it's a shift cipher!");
        System.out.println("Encoded: " + encoded);  // Aspettati un certo risultato

        String decoded = cipher.decode(encoded); //  rovwsoiv == codewars
        System.out.println("Decoded: " + decoded);  // Dovrebbe stampare "codewars"
//        ENCODE DEBUG: str(it's a shift cipher!)	key(password)	abc(abcdefghijklmnopqrstuvwxyz)
//        expected: <xt'k o vwixl qzswej!> but was: <xt'k s ovzii cahdsi!>

        System.out.println("--------ENCODE--------");
        System.out.println("(xt'k o vwixl qzswej!) EXPECTED\n(" + encoded + ") ENCODED");
        System.out.println("--------DECODE--------");
        System.out.println("(it's a shift cipher!) EXPECTED\n(" + decoded + ") DECODED");

    }

}
class VigenereCipher {
    private final String key;
    private final String abc;

    public VigenereCipher(String key, String abc) {
        this.key = key;
        this.abc = abc;
    }

    public String encode(String str) {
        char[] alfabetoArr = abc.toCharArray();
        char[] caratteriChiave = key.toCharArray();
        ArrayList<Character> alfabeto = new ArrayList<>();
        ArrayList<Integer> valoriChiave = new ArrayList<>();
        for (char carattereAlfabeto : alfabetoArr) {
            alfabeto.add(carattereAlfabeto);
        }
        for (char carattereChiave : caratteriChiave) {
            valoriChiave.add(alfabeto.indexOf(carattereChiave));
        }
        StringBuilder parolaCifrata = new StringBuilder();
        int indice = 0;
        for (int indiceParola = 0; indiceParola < str.length(); indiceParola++) {
            if(!alfabeto.contains(str.charAt(indiceParola))){
                parolaCifrata.append(str.charAt(indiceParola));
                continue;
            }
            int numeroVigenere = alfabeto.indexOf(str.charAt(indiceParola)) + valoriChiave.get(indice++);
            if (numeroVigenere >= alfabeto.size()) {
                numeroVigenere -= alfabeto.size();
            }
            parolaCifrata.append(alfabeto.get(numeroVigenere));
            if (indice == key.length()) {
                indice = 0;
            }
        }

        return parolaCifrata.toString();
    }

    public String decode(String str) {

        char[] alfabetoArr = abc.toCharArray();
        char[] caratteriChiave = key.toCharArray();
        ArrayList<Character> alfabeto = new ArrayList<>();
        ArrayList<Integer> valoriChiave = new ArrayList<>();
        for (char carattereAlfabeto : alfabetoArr) {
            alfabeto.add(carattereAlfabeto);
        }
        for (char carattereChiave : caratteriChiave) {
            valoriChiave.add(alfabeto.indexOf(carattereChiave));
        }
        StringBuilder parolaDecifrata = new StringBuilder();
        int indice = 0;

        for (int indiceParola = 0; indiceParola < str.length(); indiceParola++) {
            if(!alfabeto.contains(str.charAt(indiceParola))){
                parolaDecifrata.append(str.charAt(indiceParola));
                continue;
            }
            int numeroVigenere = alfabeto.indexOf(str.charAt(indiceParola)) - valoriChiave.get(indice++);
            if (numeroVigenere < 0) {
                numeroVigenere += alfabeto.size();
            }
            parolaDecifrata.append(alfabeto.get(numeroVigenere));
            if (indice == key.length()) {
                indice = 0;
            }
        }
        return parolaDecifrata.toString();

    }
}
