package ChallengeInteressanti;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TalismanRandomizer {
    public static void main(String[] args) {

        System.out.println("Sistema Pseudointelligente di Estrazione Aleatoria Nominativa ad Alta Entropia (S.P.E.A.N.A.E.)\nMade by Vincent." );

        List<String> classic = Arrays.asList(
                "Assassino", "Druido", "Nano", "Elfo", "Ghoul",
                "Menestrello", "Monaco", "Prete", "Profetessa",
                "Incantatrice", "Ladro", "Troll", "Guerriero", "Mago"
        );
        List<String> mietitore = Arrays.asList(
                "Cultista Oscura", "Cavaliere", "Mercante", "Saggio"
        );
        List<String> ghiacci = Arrays.asList(
                "Leprecano", "Negromante", "Capitano Ogre", "Stregone"
        );
        List<String> dungeon = Arrays.asList(
                "Amazzone", "Gladiatore", "Zingara", "Filosofo", "Spadaccino"
        );
        List<String> montuose = Arrays.asList(
                "Spiritello", "Ladra", "Immortale", "Alchimista", "Valchiria", "Vampiressa"
        );
        List<String> stagno = Arrays.asList(
                "Cavaliere Errante", "Sacerdotessa", "Cavaliere del Terrore", "Magus"
        );
        List<String> cittaa = Arrays.asList(
                "Riparatore", "Spia", "Cacciatore di Taglie", "Elementalista", "Locandiera", "Ladra Acrobata"
        );
        List<String> luna = Arrays.asList(
                "Profeta di Sventura", "Tombarolo", "Cacciatrice di Vampiri"
        );
        List<String> fuoco = Arrays.asList(
                "Derviscio", "Signore della Guerra", "Nomade", "Genio Mezzosangue"
        );
        List<String> drago = Arrays.asList(
                "Minotauro", "Cacciatore di Draghi", "Mago del Fuoco", "Prestigiatrice", "Sacerdotessa dei Draghi", "Cavalcatrice di Draghi"
        );
        List<String> messaggero = Arrays.asList(
                "Divina Ascendente", "Celestiale", "Posseduto"
        );
        List<String> boscose = Arrays.asList(
                "Antica Quercia", "Guerriero Totem", "Viandante Sincronico", "Regina dei Ragni"
        );
        List<String> cataclysm = Arrays.asList(
                "Discendente Arcano", "Barbaro", "Cavaliere Nero", "Mutante", "Raccoglitrice"
        );
        List<String> anime = Arrays.asList(
                "Arconte", "Chiaroveggente", "Collezionista di Spettri"
        );
        List<String> bestie = Arrays.asList(
                "Cacciatore di Trofei", "Specialista"
        );
        List<String> meccagon = Arrays.asList(
                "Artificiere", "Ingegnere", "Ingannatore"
        );


        HashMap<String, List<String>> personaggi = new HashMap<>();
        personaggi.computeIfAbsent("personaggi_classic", k -> new ArrayList<>()).addAll(classic);
        personaggi.computeIfAbsent("personaggi_mietitore", k -> new ArrayList<>()).addAll(mietitore);
        personaggi.computeIfAbsent("personaggi_avanzataDeiGhiacci", k -> new ArrayList<>()).addAll(ghiacci);
        personaggi.computeIfAbsent("personaggi_dungeon", k -> new ArrayList<>()).addAll(dungeon);
        personaggi.computeIfAbsent("personaggi_landeMontuose", k -> new ArrayList<>()).addAll(montuose);
        personaggi.computeIfAbsent("personaggi_stagnoSacro", k -> new ArrayList<>()).addAll(stagno);
        personaggi.computeIfAbsent("personaggi_citta", k -> new ArrayList<>()).addAll(cittaa);
        personaggi.computeIfAbsent("personaggi_lunaDiSangue", k -> new ArrayList<>()).addAll(luna);
        personaggi.computeIfAbsent("personaggi_landeDelFuoco", k -> new ArrayList<>()).addAll(fuoco);
        personaggi.computeIfAbsent("personaggi_ilDrago", k -> new ArrayList<>()).addAll(drago);
        personaggi.computeIfAbsent("personaggi_ilMessaggero", k -> new ArrayList<>()).addAll(messaggero);
        personaggi.computeIfAbsent("personaggi_landeBoscose", k -> new ArrayList<>()).addAll(boscose);
        personaggi.computeIfAbsent("personaggi_ilCataclisma", k -> new ArrayList<>()).addAll(cataclysm);
        personaggi.computeIfAbsent("personaggi_regnoDelleAnime", k -> new ArrayList<>()).addAll(anime);
        personaggi.computeIfAbsent("personaggi_leBestieAntiche", k -> new ArrayList<>()).addAll(bestie);
        personaggi.computeIfAbsent("personaggi_ilRegnoMeccanico", k -> new ArrayList<>()).addAll(meccagon);

        Scanner scanner = new Scanner(System.in);
        System.out.println(">> Inserisci il numero di giocatori:");
        int numeroGiocatori = scanner.nextInt();
        stampaLegenda();

        String[] numeroEspansioni = scanner.next().split("-");
        List<String> espansioniAttive = new ArrayList<>();

        for (String espansione : numeroEspansioni) {

            switch (espansione) {
                case "1":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_classic", Collections.emptyList()));
                    break;
                case "2":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_mietitore", Collections.emptyList()));
                    break;
                case "3":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_avanzataDeiGhiacci", Collections.emptyList()));
                    break;
                case "4":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_dungeon", Collections.emptyList()));
                    break;
                case "5":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_landeMontuose", Collections.emptyList()));
                    break;
                case "6":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_stagnoSacro", Collections.emptyList()));
                    break;
                case "7":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_citta", Collections.emptyList()));
                    break;
                case "8":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_lunaDiSangue", Collections.emptyList()));
                    break;
                case "9":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_landeDelFuoco", Collections.emptyList()));
                    break;
                case "10":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_ilDrago", Collections.emptyList()));
                    break;
                case "11":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_ilMessaggero", Collections.emptyList()));
                    break;
                case "12":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_landeBoscose", Collections.emptyList()));
                    break;
                case "13":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_ilCataclisma", Collections.emptyList()));
                    break;
                case "14":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_regnoDelleAnime", Collections.emptyList()));
                    break;
                case "15":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_leBestieAntiche", Collections.emptyList()));
                    break;
                case "16":
                    espansioniAttive.addAll(personaggi.getOrDefault("personaggi_ilRegnoMeccanico", Collections.emptyList()));
                    break;
                default:
                    System.out.println(">> TI PUZZA IL CAZZO");
                    break;
            }
        }
        System.out.println(">> ECCO I TUOI PG!");
        ArrayList<String> eroiGiocatore = new ArrayList<>();

        while (eroiGiocatore.size() != numeroGiocatori) {
            int numeroRandom = ThreadLocalRandom.current().nextInt(0, espansioniAttive.size() - 1);
            if (espansioniAttive.get(numeroRandom) != null && !eroiGiocatore.contains(espansioniAttive.get(numeroRandom))) {
                eroiGiocatore.add(espansioniAttive.get(numeroRandom));
            }
        }
        int conto = 1;
        for (String pg : eroiGiocatore) {
            System.out.println(conto++ + ": " + pg);
        }

    }

    public static void stampaLegenda() {
        System.out.println("1: Classic");
        System.out.println("2: Mietitore");
        System.out.println("3: Avanzata dei Ghiacci");
        System.out.println("4: Dungeon");
        System.out.println("5: Lande Montuose");
        System.out.println("6: Stagno Sacro");
        System.out.println("7: Città");
        System.out.println("8: Luna di Sangue");
        System.out.println("9: Lande del Fuoco");
        System.out.println("10: Il Drago");
        System.out.println("11: Il Messaggero");
        System.out.println("12: Lande Boscose");
        System.out.println("13: Il Cataclisma");
        System.out.println("14: Regno delle Anime");
        System.out.println("15: Le Bestie Antiche");
        System.out.println("16: Il Regno Meccanico");
    }
}
