package CodeAbbey;
import java.util.*;
public class CodeAbbey_CaesarShiftCipher {
    public static void main(String[] args) {
//        Cryptography is one of most interesting branches of programming. Studying its algorithms usually begins with the simple method named after famous Roman emperor Julius Caesar,
//        who used it for communicating his military secrets (and perhaps for love letters to Cleopatra).
//        We will practice deciphering encrypted messages in this problem.
//        The idea of the algorithm is simple. Each letter of the original text is substituted by another, by the following rule:
//
//        find the letter (which should be encrypted) in the alphabet;
//        move K positions further (down the alphabet);
//        take the new letter from here;
//        if "shifting" encountered the end of the algorithm, continue from its start.
//        For example, if K = 3 (shift value used by Caesar himself), then A becomes D, B becomes E, W becomes Z and Z becomes C and so on, according to the following table:
//
//        A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
//        | | | | | | | | | | | | | | | | | | | | | | | | | |
//        V V V V V V V V V V V V V V V V V V V V V V V V V V
//        D E F G H I J K L M N O P Q R S T U V W X Y Z A B C
//
//        So if the source message was VENI VIDI VICI then after encoding it becomes YHQL YLGL YLFL.
//        On the other hand encrypted message should be "shifted back" to decode it - or shifted by 26 - K which is the same.
//        So if we have encoded message HYHQ BRX EUXWXV, we can apply shift of 26 - K = 26 - 3 = 23 and find the original text to be EVEN YOU BRUTUS.
//
//        Input data will contain two integers - the number of lines of encrypted text and the value of K.
//        The following lines will contain encrypted text, consisting of capital latin letters A ... Z, each line is terminated with a dot . which should not be decoded.
//        Answer should contain the decrypted message (in a single line, no line splitting is needed).
//
//        Example:
//        input data:
//        2 3
//        YHQL YLGL YLFL.
//        HYHQ BRX EUXWXV.
//        answer:
//        VENI VIDI VICI. EVEN YOU BRUTUS.

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character>alfabeto = new ArrayList<>();
        for(char c = 'A'; c <= 'Z'; c++){
            alfabeto.add(c);
        }
        int n = scanner.nextInt(), k = scanner.nextInt();
        scanner.nextLine();
        for(int j = 0; j < n; j++) {
            String s = scanner.nextLine();
            ArrayList<Character> nuovoAlfabeto = (creaAlfabetoModificato(k, alfabeto));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sb.append(' ');
                } else if (s.charAt(i) == '.') {
                    sb.append('.');
                } else {
                    sb.append(alfabeto.get(nuovoAlfabeto.indexOf(s.charAt(i))));
                }
            }
            System.out.println(sb + " ");
        }
    }
    public static ArrayList<Character> creaAlfabetoModificato(int k, ArrayList<Character> alfabeto) {
        ArrayList<Character> nuovoAlfabeto = new ArrayList<>(alfabeto);
        ArrayList<Character> caratteriTemp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            caratteriTemp.add(nuovoAlfabeto.get(0));
            nuovoAlfabeto.remove(0);
        }
        nuovoAlfabeto.addAll(caratteriTemp);
        return nuovoAlfabeto;
    }
}