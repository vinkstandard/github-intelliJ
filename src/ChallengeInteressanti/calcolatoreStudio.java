package ChallengeInteressanti;

import java.io.*;
import java.util.*;
import java.util.regex.*;
//"C:\\Users\\franc\\OneDrive\\Desktop\\Studio\\studio\\studio.txt"

public class calcolatoreStudio {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+----------------------------------------------------------------------------------------------------+");
        System.out.println(">>> Programma di calcolo ore v1, made by Vincent.");
        System.out.println(">>> Bella francis, vediamo di calcolare un po' di ore.");
        File file = new File("C:\\Users\\Mary\\Desktop\\studio.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        ArrayList<String> timestamps = new ArrayList<>();
        for (String s : righe) {
            Pattern pattern = Pattern.compile("\\b\\d{2}:\\d{2} \\d{2}:\\d{2}\\b");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                timestamps.add(matcher.group());
            }
        }
        int minutiTotali = 0;
        for (String timestamp : timestamps) {
            String[] parti = timestamp.split(" ");
            int minutiInizio = inMinuti(parti[0]);
            int minutiFine = inMinuti(parti[1]);
            // se l'orario di fine è minore di quello di inizio, significa che passa alla mezzanotte
            if (minutiFine < minutiInizio) {
                minutiFine += 1440; // aggiunge 24 ore (1440 minuti)
            }

            minutiTotali += (minutiFine - minutiInizio);
        }

        int ore = minutiTotali / 60;
        int minuti = minutiTotali % 60;

        // inizio parte interattiva

        // set con tutti i mesi
        Set<String> mesi = new HashSet<>();
        mesi.add("gennaio");
        mesi.add("febbraio");
        mesi.add("marzo");
        mesi.add("aprile");
        mesi.add("maggio");
        mesi.add("giugno");
        mesi.add("luglio");
        mesi.add("agosto");
        mesi.add("settembre");
        mesi.add("ottobre");
        mesi.add("novembre");
        mesi.add("dicembre");
        System.out.println(">>> Di quale mese vuoi calcolare le ore di lavoro?");
        String mesec = "";
        while (true) {
            mesec = scanner.next().toLowerCase();
            if (!mesi.contains(mesec)) {
                System.out.println(">>> \"" + mesec + "\" Non è un mese valido.\n>>> Inserisci un mese valido, senzamani.");
            } else {
                break;
            }
        }
        String mese = mesec.substring(0, 1).toUpperCase() + mesec.substring(1); // l'iniziale in maiuscolo

        System.out.println(">>> Durante il mese di " + mese + ", hai lavorato per un totale di: " + ore + " ore e " + minuti + " minuti.");
        System.out.println(">>> MESSAGGIO DA COPIARE: " + mese + ": " + ore + " ore, " + minuti + " minuti.");
        System.out.println(">>> Ti consiglio di pushare questo e di cancellare tutte le timestamp dal documento di testo.");
        System.out.println(">>> Se preferisci fare delle modifiche al programma contattami e vediamo cosa possiamo modificare.");
        System.out.println(">>> p.s.\n>>> I commenti e i giorni ho dovuto ometterli perché erano scritti in modo irregolare,\n>>> se li vuoi aggiungere dovrai scriverli in modo diverso d'ora in avanti.");
        System.out.println("+----------------------------------------------------------------------------------------------------+");
    }

    // metodo per convertire un orario HH:MM in minuti totali dall'inizio della giornata
    private static int inMinuti(String tempo) {
        String[] parti = tempo.split(":");
        int ore = Integer.parseInt(parti[0]);
        int minuti = Integer.parseInt(parti[1]);
        return ore * 60 + minuti;
    }
}
