package CodeAbbey;
import java.util.*;

public class CodeAbbey_CeasarCipherCracker {

//    https://www.codeabbey.com/index/task_view/caesar-cipher-cracker
//
//    Input data will contain the number of encrypted messages in the first line.
//    Next lines will contain the encrypted lines themselves. Each line is encoded with separate key!
//    Answer should contain three first words of each decrypted line followed by the value of the key. Several answers should be separated with spaces.
//
//    Additional info:
//
//    the key will always be a value between 1 and 25 inclusive;
//    lines will contain only capital latin letters and spaces to separate words;
//    original messages are in English, from 60 to 100 characters long.
//    Example:
//
//    input data:
//    2
//    XIP DBSFT PG ESFBNT
//    VJQWIJ KV OCMGU VJKPIU XGTA SWGGT
//
//    answer:
//    WHO CARES OF 1 THOUGH IT MAKES 2

//        forse c'è un metodo migliore oltre alla bruteforce, magari consultare un vocabolario per ogni iterazione di k
//        e la stringa con più match nel vocabolario deve eessere quella giusta, da capire.
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
        ArrayList<Character> alfabeto = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
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
