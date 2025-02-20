package CodeAbbey;
import java.util.*;
public class CodeAbbey_CaesarShiftCipher {
    public static void main(String[] args) {

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