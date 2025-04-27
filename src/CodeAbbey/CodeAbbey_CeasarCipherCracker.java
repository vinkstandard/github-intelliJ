package CodeAbbey;
import java.util.*;

public class CodeAbbey_CeasarCipherCracker {

//    https://www.codeabbey.com/index/task_view/caesar-cipher-cracker

    private static int numeroParola = 1;

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
        char[] m = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        ArrayList<Character> alfabeto = new ArrayList<>();
        for (char c : m) {
            alfabeto.add(c);
        }
        ArrayList<String> parole = new ArrayList<>();

        for (int k = 0; k < alfabeto.size(); k++) {
            ArrayList<Character> daMod = new ArrayList<>();
            for (int i = k; i < alfabeto.size(); i++) {
                daMod.add(alfabeto.get(i));
            }
            if (k != 0) {
                for (int i = 0; i < k; i++) {
                    daMod.add(alfabeto.get(i));
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sb.append(" ");
                } else {
                    sb.append(alfabeto.get(daMod.indexOf(s.charAt(i))));
                }
            }
            parole.add(sb.toString());
        }
        stampaParole(parole);
    }

    public static void stampaParole(ArrayList<String> parole) {

        System.out.println("-------- Inizio variazioni per parola numero " + numeroParola + " --------");
        for (int i = 0; i < parole.size(); i++) {
            System.out.println((i + 1) + ": " + parole.get(i));
        }
        System.out.println("-------- Fine variazioni per parola numero " + numeroParola + " --------");
        numeroParola++;
    }
}
