package CodeAbbey;
import java.util.*;

public class CodeAbbey_CeasarCipherCracker {

//    https://www.codeabbey.com/index/task_view/caesar-cipher-cracker
//    4


    public static void main(String[] args) {
        String testo = """
                OXDA BLXAN JWM BNENW HNJAB JPX QNAN MRNB RW VH KXBBXV RO KUXXM KN CQN YARLN XO CQN JMVRAJUCH
                EB GUHDPV HDFK RQH LQWR D VHYHUDO ZRUOG QR VRRQHU VSRNHQ WKDQ EURNHQ
                NJOET JOOPDFOU BOE RVJFU UBLF UVSOT BMM BSPVOE CVU EPFT OPU NPWF
                VA NAPVRAG CREFVN GURER JNF N XVAT ABE VEBA ONEF N PNTR PNEGUNTR ZHFG OR QRFGEBLRQ""";
        String[] testi = testo.split("\n");
        for (String t : testi) {
            CrackerBruteForce(t);
        }
    }

    public static void CrackerBruteForce(String s) {
        int parola = 1;
        char[] m = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        ArrayList<Character> alfabeto = new ArrayList<>();
        for (char c : m) {
            alfabeto.add(c);
        }
        System.out.println();
        System.out.println("Stringa da cercare: " + s);

        for (int k = 0; k < alfabeto.size(); k++) {
            ArrayList<Character> daMod = new ArrayList<>();
            System.out.println("--------------\nValore di K = " + k);
            for (int i = k; i < alfabeto.size(); i++) {
                daMod.add(alfabeto.get(i));
            }
            if (k != 0) {
                for (int i = 0; i < k; i++) {
                    daMod.add(alfabeto.get(i));
                }
            }
            for (char c : daMod) {          // visualizzazione per debug
                System.out.print(c + " ");
            }
            System.out.println();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sb.append(" ");
                } else {
                    sb.append(alfabeto.get(daMod.indexOf(s.charAt(i))));
                }
            }
            System.out.println("Stringa trovata: " + sb.toString());
        }
    }
}
