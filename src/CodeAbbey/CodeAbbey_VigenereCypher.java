package CodeAbbey;

import java.util.ArrayList;

public class CodeAbbey_VigenereCypher {
    public static void main(String[] args) {

//        https://www.codeabbey.com/index/task_view/vigenere-cipher
//        We've already seen that Caesar's Cipher could be easily broken with the analysis of letter frequencies.
//
//        Vigenere's algorithm brings improvement. We choose not just a single shift value, but small array of such values (let us call it key),
//        and then each next letter of the original text is shifted by the next value from the key.
//
//        Of course if the key is very long (especially, as long as the original text itself) the system becomes unbrekable.
//        However in practice the key is usually short enough (represented by some word) and we wrap to its beginning after reaching the end - thus the algorithm is imperfect.
//        So let's assume that:
//
//        The key is given by some word, which is converted to array of shift values using letter numbers in alphabet, e.g. cab becomes [2, 0, 1];
//        For every letter of the original text shift value is chosen as key[i % k] where i is the index in the original text and k is the length of the key.
//        Before we try to break it, let's write the implementation of this algorithm, to make sure we understand it properly.
//
//        Input data the first line contains the text to be encoded, only small latin letters with no spaces.
//        The second line contains the key.
//        Answer should give the encrypted text.
//
//        Example:
//
//        input data:
//        attackatdusk
//        c a b
//        2 0 1
//        answer:
//        ctucclctewsl

        String parola = "rapportoimmediato", chiave = "vermevermevermeve";

        ArrayList<Character> alfabeto = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alfabeto.add(c);
        }

        ArrayList<Integer> valoriChiave = new ArrayList<>();
        char[] caratteriChiave = chiave.toCharArray();
        for (char carattere : caratteriChiave) {
            valoriChiave.add(alfabeto.indexOf(carattere));
        }
        StringBuilder parolaDecifrata = new StringBuilder();
        int indice = 0;
        for (int indiceParola = 0; indiceParola < parola.length(); indiceParola++) {

            int numeroVigenere = alfabeto.indexOf(parola.charAt(indiceParola)) + valoriChiave.get(indice++);
            if (numeroVigenere >= alfabeto.size()) {
                numeroVigenere -= alfabeto.size();
            }
            parolaDecifrata.append(alfabeto.get(numeroVigenere));
            if (indice == chiave.length()) {
                indice = 0;
            }
        }

        System.out.println("Parola decifrata: " + parolaDecifrata);

    }
}
