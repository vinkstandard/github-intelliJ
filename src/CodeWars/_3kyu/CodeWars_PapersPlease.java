package CodeWars._3kyu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.*;

public class CodeWars_PapersPlease {
    //            https://www.codewars.com/kata/59d582cafbdd0b7ef90000a0/train/java
//  "Not every single possible case has been listed in this Description; use the test feedback to help you handle all cases." <--- frase da paraculo svogliato, e anche un po fdp
    private ArrayList<String> nazioniApprovate = new ArrayList<>();

    // mappa nazioni e i vaccini richiesti
    private Map<String, Set<String>> richiesteVaccini = new HashMap<>() {{
        put("Arstotzka", new HashSet<>());
        put("Kolechia", new HashSet<>());
        put("Impor", new HashSet<>());
        put("Antegria", new HashSet<>());
        put("Obristan", new HashSet<>());
        put("Republia", new HashSet<>());
        put("United Federation", new HashSet<>());
    }};
    private String ricercato = null;
    private boolean richiestoPassaporto; // valido per tutti, sia stranieri che abitanti di Arstotzka
    private static final LocalDate EXPIRY_CUTOFF = LocalDate.of(1982, 11, 22); // la data massima per controllare la scadenza
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd"); // per formattare le date di scadenza
    private boolean richiestoPermessoAccessoStranieri;
    private boolean richiestaIdCardArstotzka;
    private boolean richiestoWorkPass;
    private static final List<String> NAZIONI = List.of(
            "Antegria", "Impor", "Kolechia", "Obristan", "Republia",
            "United Federation", "Arstotzka"
    );

    public static void main(String[] args) {
        CodeWars_PapersPlease inspector = new CodeWars_PapersPlease();
//                       CASI BOLLETTINO

//        String bollettino = "Entrants require passport\n" +
//                "Allow citizens of Arstotzka, Obristan\n" +
//                "Wanted by the State: Hubert Popovic";

//        String bollettino = "Entrants require passport\n" +
//                "Allow citizens of Arstotzka\n" +
//                "Wanted by the State: Giancarlo, Malva";

//        bollettino per il flood
        String bollettino = "Entrants require passport\n" +
                "Allow citizens of Antegria, Impor, Kolechia, Obristan, Republia, United Federation\n" +
                "Foreigners require access permit";

        inspector.receiveBulletin(bollettino);

//              CASI PERSONE SINGOLE

//         caso guyovich con passaporto
//        Map<String, String> guyovich = new HashMap<>();
//        guyovich.put("passport", "ID#: GC07D-FU8AR\n" +
//                "NATION: Arstotzka\n" +
//                "NAME: Guyovich, Russian\n" +
//                "DOB: 1933.11.28\n" +
//                "SEX: M\n" +
//                "ISS: East Grestin\n" +
//                "EXP: 1983.07.10\n"
//        );
//        System.out.println("Guyovich: "+ inspector.inspect(guyovich));

//         caso guyovich senza passaporto
//        Map<String,String> guyovich = new HashMap<>();
//        guyovich.put("access_permit", "NAME: Guyovich, Russian\nNATION: Obristan\nID#: TE8M1-V3N7R\nPURPOSE: TRANSIT\nDURATION: 14 DAYS\nHEIGHT: 159cm\nWEIGHT: 60kg\nEXP: 1983.07.13");
//        System.out.println("Guyovich: " + inspector.inspect(guyovich));

//        caso roman con passaporto e concessioneAsilo
//        Map<String,String> roman = new HashMap<>();
//        roman.put("passport", "ID#: WK9XA-LKM0Q\nNATION: United Federation\nNAME: Dolanski, Roman\nDOB: 1933.01.01\nSEX: M\nISS: Shingleton\nEXP: 1983.05.12");
//        roman.put("grant_of_asylum", "NAME: Dolanski, Roman\nNATION: United Federation\nID#: Y3MNC-TPWQ2\nDOB: 1933.01.01\nHEIGHT: 176cm\nWEIGHT: 71kg\nEXP: 1983.09.20");
//        System.out.println("Roman: " + inspector.inspect(roman));

//        caso banned nation
//        Map<String, String> weiss = new HashMap<>();
//        weiss.put("passport", "ID#: GDT2W-OFN93\n" +
//                "NATION: Impor\n" +
//                "NAME: Weiss, Malva\n" +
//                "DOB: 1961.11.04\n" +
//                "SEX: F\n" +
//                "ISS: Tsunkeido\n" +
//                "EXP: 1985.11.18\n"
//        );
//        System.out.println(inspector.inspect(weiss));

//        caso documento scaduto


//            CASO FLOOD

//        List<Map<String,String>> persone = new ArrayList<>();
//        Map<String, String> pejic = new HashMap<>();
//        pejic.put("passport", "ID#: NJGPP-SLQSV\n" +
//                "NATION: Kolechia\n" +
//                "NAME: Pejic, Ivanka\n" +
//                "DOB: 1951.08.25\n" +
//                "SEX: F\n" +
//                "ISS: West Grestin\n" +
//                "EXP: 1985.08.18\n"
//        );
//        persone.add(pejic);
//
//        Map<String, String> hassad = new HashMap<>();
//        hassad.put("passport", "ID#: HM2ZG-HBMPO\n" +
//                "NATION: Kolechia\n" +
//                "NAME: Hassad, Aaron\n" +
//                "DOB: 1955.06.22\n" +
//                "SEX: M\n" +
//                "ISS: Vedor\n" +
//                "EXP: 1985.07.29\n"
//        );
//        persone.add(hassad);
//
//        Map<String, String> peterson = new HashMap<>();
//        peterson.put("passport", "ID#: VRIAE-RRU6W\n" +
//                "NATION: Impor\n" +
//                "NAME: Peterson, Isaak\n" +
//                "DOB: 1952.12.27\n" +
//                "SEX: M\n" +
//                "ISS: Haihan\n" +
//                "EXP: 1985.05.20\n"
//        );
//        persone.add(peterson);
//
//        Map<String, String> baryshnikova = new HashMap<>();
//        baryshnikova.put("passport", "ID#: AWLDT-LWAW9\n" +
//                "NATION: Impor\n" +
//                "NAME: Baryshnikova, Ivan\n" +
//                "DOB: 1962.11.17\n" +
//                "SEX: M\n" +
//                "ISS: Enkyo\n" +
//                "EXP: 1981.04.19\n"
//        );
//        persone.add(baryshnikova);
//
//        Map<String, String> bergman = new HashMap<>();
//        bergman.put("passport", "ID#: Y3U57-IRY46\n" +
//                "NATION: Kolechia\n" +
//                "NAME: Bergman, Abdullah\n" +
//                "DOB: 1936.08.26\n" +
//                "SEX: M\n" +
//                "ISS: Vedor\n" +
//                "EXP: 1983.12.02\n"
//        );
//        persone.add(bergman);
//
//        Map<String, String> watson = new HashMap<>();
//        watson.put("passport", "ID#: XYYKB-Y7WGU\n" +
//                "NATION: Obristan\n" +
//                "NAME: Watson, Vanya\n" +
//                "DOB: 1926.01.07\n" +
//                "SEX: M\n" +
//                "ISS: Skal\n" +
//                "EXP: 1984.03.05\n"
//        );
//        persone.add(watson);
//
//        Map<String, String> vazquez = new HashMap<>();
//        vazquez.put("passport", "ID#: ZX5XQ-ZRMNS\n" +
//                "NATION: Kolechia\n" +
//                "NAME: Vazquez, Juliette\n" +
//                "DOB: 1953.02.02\n" +
//                "SEX: F\n" +
//                "ISS: West Grestin\n" +
//                "EXP: 1985.09.09\n"
//        );
//        persone.add(vazquez);
//
//        int contoPersona = 0;
//        for (Map<String, String> persona : persone) {
//            System.out.println(contoPersona + ":" + inspector.inspect(persona));
//            contoPersona++;
//        }

//        caso con passaporto e access_permit con id non matchati
//        Map<String, String> karnov = new HashMap<>();
//        karnov.put("passport", "ID#: A8V2V-FVMWV\n" +
//                "NATION: Antegria\n" +
//                "NAME: Karnov, Yelena\n" +
//                "DOB: 1942.07.31\n" +
//                "SEX: F\n" +
//                "ISS: Outer Grouse\n" +
//                "EXP: 1984.01.30\n"
//        );
//
//        karnov.put("access_permit", "ID#: DW58K-X07H4\n" +
//                "NATION: Antegria\n" +
//                "NAME: Karnov, Yelena\n" +
//                "PURPOSE: VISIT\n" +
//                "DURATION: 14 DAYS\n" +
//                "HEIGHT: 150.0cm\n" +
//                "WEIGHT: 47.0kg\n" +
//                "EXP: 1983.05.20\n"
//        );
//                System.out.println(inspector.inspect(karnov));

    }

    // metodo per ricevere e processare il bulletin giornaliero
    public void receiveBulletin(String bulletin) {

        System.out.println("BULLETIN: " + bulletin);  // debug
        String[] righeBollettino = bulletin.split("\n");
        for (String riga : righeBollettino) {

//            richiesto id per quelli dell'Arstotzka
            if (riga.equals("Citizens of Arstotzka require ID card")) {
                richiestaIdCardArstotzka = true;
            }

//             approvare nazioni
            if (riga.startsWith("Allow citizens of")) {
                String[] nazioni = riga.replace("Allow citizens of", "").trim().split(", ");
                for (String s : nazioni) {
                    if (!nazioniApprovate.contains(s)) { // per evitare di aggiungere duplicati
                        nazioniApprovate.add(s);
                    }
                }
            }

//             disapprovare nazioni
            else if (riga.startsWith("Deny citizens of")) {
                String[] nazioni = riga.replace("Deny citizens of", "").trim().split(", ");
                for (String s : nazioni) {
                    nazioniApprovate.remove(s);
                }
            }

//             richiesta di passaporto
            else if (riga.equals("Entrants require passport")) {
                richiestoPassaporto = true;
            }

//             richiesta di accesso per stranieri
            else if (riga.equals("Foreigners require access permit")) {
                richiestoPermessoAccessoStranieri = true;
            }

//              chiamata per il metodo per gestire le vaccinazioni
            if (riga.contains("vaccination")) {
                gestisciRigaVaccino(riga);
            }

//              richiesto il workpass
            if (riga.equals("Workers require work pass")) {
                richiestoWorkPass = true;
            }

//             aggiunta ricercato
            else if (riga.startsWith("Wanted by the State:")) {
                ricercato = riga.replace("Wanted by the State:", "").trim();

            }
        }
    }

    private void gestisciRigaVaccino(String riga) {

        Pattern vaccinoPattern = Pattern.compile("require[s]? (.+?) vaccination");
        Matcher matcher = vaccinoPattern.matcher(riga);
        if (!matcher.find()) return;

        String vaccino = matcher.group(1).toUpperCase(); // per gestire "HPV"

        if (riga.startsWith("Entrants")) {
            // aggiungo il vaccino a tutte le nazioni
            for (String nazione : NAZIONI) {
                richiesteVaccini.computeIfAbsent(nazione, k -> new HashSet<>()).add(vaccino);
            }
        } else if (riga.startsWith("Foreigners")) {
            // tutte tranne l'arstotzka
            for (String nazione : NAZIONI) {
                if (!nazione.equals("Arstotzka")) {
                    richiesteVaccini.computeIfAbsent(nazione, k -> new HashSet<>()).add(vaccino);
                }
            }
        } else if (riga.startsWith("Citizens of")) {
            // estraggo le nazioni le nazioni specifiche dalla frase
            String sub = riga.substring("Citizens of ".length(), riga.indexOf(" require")).trim(); // le nazioni si trovano da "Citizen of" e finiscono a "require"
            String[] nazioni = sub.split(",\\s*");
            for (String nazione : nazioni) {
                richiesteVaccini.computeIfAbsent(nazione.trim(), k -> new HashSet<>()).add(vaccino);
            }
        }
    }

    //     metodo per ispezionare
    public String inspect(Map<String, String> person) {

        System.out.println("PERSON: " + person);  // debug
        HashMap<String, String> passaporto = parseDocument(person, "passport");
        HashMap<String, String> concessioneAsilo = parseDocument(person, "grant_of_asylum");
        HashMap<String, String> permessoAccesso = parseDocument(person, "access_permit");
        HashMap<String, String> permessoDiLavoro = parseDocument(person, "work_pass");
        HashMap<String, String> autorizzazioneDiplomatica = parseDocument(person, "diplomatic_authorization");
        HashMap<String, String> certificatoVaccinazione = parseDocument(person, "certificate_of_vaccination");
        HashMap<String, String> idCard = parseDocument(person, "ID_card");

        // solo questi tre documenti hanno la sezione "NATION", da questi capiamo se è uno straniero o no, se è un lavoratore, e la nazione di provenienza
        boolean isForeigner = false;
        String nazioneDiProvenienza = "";
        boolean isWorker = false;

        if (passaporto.get("NATION") != null && !passaporto.get("NATION").equals("Arstotzka")) {
            nazioneDiProvenienza = passaporto.get("NATION");
            isForeigner = true;
        } else if (concessioneAsilo.get("NATION") != null && !concessioneAsilo.get("NATION").equals("Arstotzka")) {
            nazioneDiProvenienza = concessioneAsilo.get("NATION");
            isForeigner = true;
        } else if (permessoAccesso.get("NATION") != null && !permessoAccesso.get("NATION").equals("Arstotzka")) {
            nazioneDiProvenienza = permessoAccesso.get("NATION");
            isForeigner = true;
        }

        if (permessoAccesso.get("PURPOSE") != null && permessoAccesso.get("PURPOSE").equals("WORK")) {
            isWorker = true;
        }

//         ----------- verifica criminale -----------
        if (ricercato != null) {
            // modifichiamo il nome, dato che nel bulletin il formato è "Nome Cognome", mentre in tutti i documenti è "Cognome, Nome" ffs
            // forse non dovrò farlo solo per il passaporto?
            if (passaporto.containsKey("NAME")) {
                String nomeTemp = passaporto.get("NAME");
                if (nomeTemp != null && nomeTemp.contains(",")) {
                    String[] parts = nomeTemp.split(",");
                    String nomeFinale = parts[1].trim() + " " + parts[0].trim();
                    if (nomeFinale.equals(ricercato)) {
                        return "Detainment: Entrant is a wanted criminal.";
                    }
                }
            }
        }

//        ----------- check se hanno una valida autorizzazione diplomatica -----------
        if (person.containsKey("diplomatic_authorization")) {
            String[] accessi = autorizzazioneDiplomatica.get("ACCESS").split(", ");
            boolean autorizzazioneArstotzka = false;
            for (String accesso : accessi) {
                if (accesso.equals("Arstotzka")) {
                    autorizzazioneArstotzka = true;
                    break;
                }
            }
            if (!autorizzazioneArstotzka) {
                return "Entry denied: invalid diplomatic authorization.";
            }
        }

//        ----------- controllo se la nazione di provenienza è la stessa su tutti i documenti -----------
        ArrayList<String> nazioniDiProvenienza = new ArrayList<>();
        if (passaporto.containsKey("NATION")) nazioniDiProvenienza.add(passaporto.get("NATION"));
        if (concessioneAsilo.containsKey("NATION")) nazioniDiProvenienza.add(concessioneAsilo.get("NATION"));
        if (permessoAccesso.containsKey("NATION")) nazioniDiProvenienza.add(permessoAccesso.get("NATION"));
        if (nazioniDiProvenienza.size() > 1) {
            String nazione = nazioniDiProvenienza.get(0);
            for (String s : nazioniDiProvenienza) {
                if (!s.equals(nazione)) {
                    return "Detainment: nationality mismatch.";
                }
            }
        }

//            ----------- controllo id su tutti i documenti -----------
        ArrayList<String> idTotali = new ArrayList<>();
        if (passaporto.containsKey("ID#")) idTotali.add(passaporto.get("ID#"));
        if (concessioneAsilo.containsKey("ID#")) idTotali.add(concessioneAsilo.get("ID#"));
        if (permessoAccesso.containsKey("ID#")) idTotali.add(permessoAccesso.get("ID#"));
        if (certificatoVaccinazione.containsKey("ID#")) idTotali.add(certificatoVaccinazione.get("ID#"));
        if (idTotali.size() > 1) {
            for (int i = 0; i < idTotali.size() - 1; i++) {
                if (!idTotali.get(i).equals(idTotali.get(i + 1))) {
                    return "Detainment: ID number mismatch.";
                }
            }
        }

        //         -----------  verifica mancanza passaporto -----------
        if (!person.containsKey("passport") && richiestoPassaporto) {
            return "Entry denied: missing required passport.";
        }

//                 ----------- check se c'è bisogno dell'id card per quelli dell'Arstotzka -----------

        if (richiestaIdCardArstotzka && !isForeigner && !person.containsKey("ID_card")) {
            return "Entry denied: missing required ID card.";
        }

        //        controllo se i nomi combaciano in tutti i documenti
        ArrayList<String> nomi = new ArrayList<>();
        if (passaporto.get("NAME") != null) nomi.add(passaporto.get("NAME"));
        if (permessoAccesso.get("NAME") != null) nomi.add(permessoAccesso.get("NAME"));
        if (concessioneAsilo.get("NAME") != null) nomi.add(concessioneAsilo.get("NAME"));
        if (idCard.get("NAME") != null) nomi.add(idCard.get("NAME"));
        String nomeTemp = nomi.get(0);
        for (String nome : nomi) {
            if (!nome.equals(nomeTemp)) {
                return "Detainment: name mismatch.";
            }
        }

//              ----------- controllo scadenze -----------
        if (passaporto.get("EXP") != null) {
            LocalDate dataScadenza = LocalDate.parse(passaporto.get("EXP"), FORMATTER);
            if (!dataScadenza.isAfter(EXPIRY_CUTOFF)) {
                return "Entry denied: passport expired.";
            }
        }
        if (permessoDiLavoro.get("EXP") != null) {
            LocalDate dataScadenza = LocalDate.parse(permessoDiLavoro.get("EXP"), FORMATTER);
            if (!dataScadenza.isAfter(EXPIRY_CUTOFF)) {
                return "Entry denied: work pass expired.";
            }
        }
        if (permessoAccesso.get("EXP") != null) {
            LocalDate dataScadenza = LocalDate.parse(permessoAccesso.get("EXP"), FORMATTER);
            if (!dataScadenza.isAfter(EXPIRY_CUTOFF)) {
                return "Entry denied: access permit expired.";
            }
        }
        if (concessioneAsilo.get("EXP") != null) {
            LocalDate dataScadenza = LocalDate.parse(concessioneAsilo.get("EXP"), FORMATTER);
            if (!dataScadenza.isAfter(EXPIRY_CUTOFF)) {
                return "Entry denied: grant of asylum expired.";
            }
        }

//           ----------- controllo se la nazione è nella lista di quella approvate -----------
        if (!nazioniApprovate.contains(passaporto.get("NATION"))) {
            return "Entry denied: citizen of banned nation.";
        }

//           ----------- controllo sulla validità delle vaccinazioni -----------

        Set<String> vacciniDaFare = richiesteVaccini.get(nazioneDiProvenienza);
        // controllo se la nazione richiede dei vaccini prima di entrare
        if (vacciniDaFare != null && !vacciniDaFare.isEmpty()) {
            // se la persona non ha il certificato
            if (!person.containsKey("certificate_of_vaccination")) {
                return "Entry denied: missing required certificate of vaccination.";
            }
            // se invece ce l'ha, controlliamo se ha tutto in regola
            String[] vax = certificatoVaccinazione.get("VACCINES").split(", ");
            Set<String> vacciniCompletati = new HashSet<>(Arrays.asList(vax));
            for (String vaccino : vacciniDaFare) {
                if (!vaccino.equals("HPV")) {
                    vaccino = vaccino.toLowerCase();
                }
                if (!vacciniCompletati.contains(vaccino)) {
                    return "Entry denied: missing required vaccination.";
                }
            }
        }
//        ----------- check per vedere se gli stranieri hanno il permesso di accesso -----------
        if (richiestoPermessoAccessoStranieri && isForeigner) {
            if (!person.containsKey("access_permit") && !person.containsKey("grant_of_asylum") && !person.containsKey("diplomatic_authorization") && person.containsKey("work_pass")) {
                return "Entry denied: missing required access permit.";
            }
        }
//        ----------- controllo se quando è richiesto un workpass, la persona ne abbia uno con se -----------
        if (richiestoWorkPass && isForeigner && isWorker) {
            if (!person.containsKey("work_pass") && !person.containsKey("grant_of_asylum") && !person.containsKey("diplomatic_authorization") && !person.containsKey("access_permit")) {
                return "Entry denied: missing required work pass.";
            }
        }

        // se non procca qualunque uno dei return sopra, allora può entrare
        if (!isForeigner) {
            return "Glory to Arstotzka.";
        }
        return "Cause no trouble.";
    }

    // metodo per inizializzare le mappe(documenti)
    private HashMap<String, String> parseDocument(Map<String, String> person, String chiaveDocumento) {
        HashMap<String, String> mappa = new HashMap<>();
        if (person.containsKey(chiaveDocumento)) {
            String[] dati = person.get(chiaveDocumento).split("\n");
            for (String s : dati) {
                Pattern pattern = Pattern.compile("^([^:]+):");
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    String chiave = matcher.group(1).trim();
                    String valore = s.replaceFirst("^([^:]+):\\s*", "").trim();
                    mappa.put(chiave, valore);
                }
            }
        }
        return mappa;
    }
}
