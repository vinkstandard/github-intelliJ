package CodeWars._5kyu;
import java.util.*;

public class CodeWars_FourLetterWordsMutations {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5cb5eb1f03c3ff4778402099/train/java
//        caso con first = 0
//        String[] alice = new String[]{"plat", "rend", "bear", "soar", "mare", "pare", "flap", "neat", "clan", "pore"};
//        String[] bob = new String[]{"boar", "clap", "mere", "lend", "near", "peat", "pure", "more", "plan", "soap"};
//        System.out.println("CASO CON -maze = " + mutations(alice,bob,"maze",first));
//        System.out.println("CASO CON -send = " + mutations(alice,bob,"send",first));
//        int first = 0;

//        caso con first = 1
//        String[]alice = new String[]{"plat", "rend", "bear", "soar", "mare", "pare", "flap", "neat", "clan", "pore"};
//        String[]bob= new String[]{"boar", "clap", "mere", "lend", "near", "peat", "pure", "more", "plan", "soap"};
//        int first = 1;
//        System.out.println("CASO CON -flap = " + mutations(alice,bob,"flap",first));



        String[] bob = new String[]{
                "nibs", "doit", "vote", "dame", "jams", "plew", "lieu", "kore", "bait", "pals",
                "deco", "clod", "word", "brin", "trek", "samp", "berk", "byrl", "geck", "trot",
                "clay", "otto", "koel", "hymn", "deva", "grin", "pens", "nipa", "waif", "epic",
                "hums", "coss", "buff", "done", "husk", "egad", "ruby", "bema", "must", "nick",
                "rate", "obia", "recs", "haft", "vine", "lull", "bota", "chis", "slam", "rods",
                "aals", "foys", "woad", "wine", "want", "loid", "ursa", "york", "nuke", "legs",
                "kyak", "temp", "tuck", "caul", "doty", "skew", "crab", "kudu", "char", "hens",
                "plop", "mary", "gear", "bris", "gent", "mity", "heme", "noes", "ryke", "void",
                "clef", "racy", "ruga", "jabs", "urps", "bock", "kind", "rung", "harl", "ouzo",
                "nana", "sate", "luvs", "feta", "dose", "fray", "jura", "acts", "reed", "pawn",
                "agly", "bute", "cops", "hern", "pree", "lire", "tori", "eyen", "soil", "said",
                "lier", "topi", "mesh", "amia", "paul", "pled", "sump", "rede", "paws", "alga",
                "pulp", "mail", "yaps", "pacs", "ends", "cozy", "juco", "gaga", "seis", "wash",
                "vive", "deem", "virl", "abet", "rads", "bens", "waul", "dabs", "dorm", "ting",
                "mull", "toro", "slap", "eros", "soap", "swam", "jell", "lung", "beds", "troy",
                "tarn", "mack", "jeff", "wake", "twae", "pooh", "piki", "cosy", "joke", "idle",
                "mica", "ribs", "tide", "okes", "tole", "suds", "pika", "rapt", "rows", "opus",
                "wham", "chip", "tied", "oxes", "mite", "gids", "area", "dorp", "roam", "hark",
                "whup", "derv", "mina", "zine", "tout", "nubs", "rubs", "nose", "bias", "mano",
                "owls", "ties", "sake", "leal", "bale", "from", "ptui", "djin", "amah", "loir"
        };
        String[] alice = new String[]{
                "vacs", "gale", "area", "reif", "acyl", "qaid", "clue", "bard", "lock", "wean",
                "rile", "edgy", "mace", "lown", "gins", "juts", "roes", "rite", "vera", "gems",
                "site", "drat", "waws", "teed", "mart", "yuck", "mibs", "fohn", "muso", "holy",
                "mitt", "maul", "busy", "pave", "arid", "sows", "path", "mans", "bams", "boho",
                "byrl", "late", "hurt", "dung", "kafs", "gamp", "psis", "sewn", "odas", "deal",
                "peri", "ados", "peds", "heth", "hath", "lino", "asks", "hear", "knee", "zori",
                "tsar", "lava", "skat", "alga", "emyd", "anna", "axed", "leat", "this", "clan",
                "dons", "howf", "diff", "pugh", "pens", "fear", "sane", "kine", "corm", "loco",
                "brew", "mull", "ance", "cyma", "obes", "oust", "mums", "eche", "pets", "wack",
                "soot", "owed", "weet", "oots", "caky", "mire", "loup", "dots", "aims", "deus",
                "doth", "juju", "fill", "mats", "woos", "fora", "zill", "hill", "hymn", "axel",
                "used", "boon", "amok", "vavs", "anon", "wine", "paul", "eave", "raki", "udon",
                "oyer", "undo", "bota", "suqs", "iwis", "feat", "vasa", "soon", "ajar", "pops",
                "yagi", "sacs", "lots", "suet", "emus", "opal", "glim", "kaon", "slob", "mirs",
                "ayes", "ween", "thro", "awns", "axal", "dups", "odds", "hern", "sups", "papa",
                "lass", "toke", "kiss", "foxy", "sims", "jibe", "karn", "vang", "biro", "bidi",
                "zeds", "gama", "vibe", "mirk", "sues", "jato", "rhos", "bock", "dunt", "aves",
                "burn", "lied", "isle", "ixia", "meal", "wend", "gent", "bema", "mako", "heap",
                "ager", "lion", "waft", "bars", "vega", "huff", "kiva", "pogo", "ales", "mean",
                "deco", "goop", "info", "gave", "suks", "tale", "swad", "bute", "fava", "fobs"
        };
        int first = 1;
        System.out.println("CASO CON -make = " + mutations(alice,bob,"make",first));
        // expected <1>

    }
    public static int mutations(String[] alice, String[] bob, String word, int first) {

        ArrayList<String> paroleGiocatore1;
        ArrayList<String> paroleGiocatore2;
        if (first == 0) {
            paroleGiocatore1 = new ArrayList<>(Arrays.asList(alice));
            paroleGiocatore2 = new ArrayList<>(Arrays.asList(bob));
        } else {
            paroleGiocatore1 = new ArrayList<>(Arrays.asList(bob));
            paroleGiocatore2 = new ArrayList<>(Arrays.asList(alice));
        }

        ArrayList<String> paroleUsate = new ArrayList<>();
        paroleUsate.add(word);
        boolean giocatore1Good = false;
        boolean giocatore2Good = false;

        while (true) {

            String parolaDaCercare = word;
            System.out.println("--------------------INIZIO GIRO, PAROLA: " + word);
            giocatore1Good = false;
            turnoGiocatore1:
            for (int indiceLettera = 0; indiceLettera < parolaDaCercare.length(); indiceLettera++) {
                for (char c = 'a'; c < 'z'; c++) {
                    StringBuilder sb = new StringBuilder(parolaDaCercare);
                    sb.setCharAt(indiceLettera, c);
                    if (paroleGiocatore1.contains(sb.toString()) && !paroleUsate.contains(sb.toString())) {
                        if (haLettereUniche(sb.toString())) {
                            paroleUsate.add(sb.toString());
                            word = sb.toString();
                            parolaDaCercare = word;
                            System.out.println("PAROLA GIOCATORE 1: " + sb);
                            giocatore1Good = true;
                            break turnoGiocatore1;
                        }
                    }
                }
            }
            if (!giocatore1Good) {
                System.out.println("GIOCATORE 1: PAROLE FINITE");
            }
            if (!giocatore1Good && giocatore2Good) {
                if (first == 0) {
                    System.out.println("USCITA 1");
                    return 1;
                } else {
                    System.out.println("USCITA 2");
                    return 0;
                }
            }

            giocatore2Good = false;
            turnoGiocatore2:
            for (int indiceLettera = 0; indiceLettera < parolaDaCercare.length(); indiceLettera++) {
                for (char c = 'a'; c < 'z'; c++) {
                    StringBuilder sb = new StringBuilder(parolaDaCercare);
                    sb.setCharAt(indiceLettera, c);
                    if (paroleGiocatore2.contains(sb.toString()) && !paroleUsate.contains(sb.toString())) {
                        if (haLettereUniche(sb.toString())) {
                            paroleUsate.add(sb.toString());
                            word = sb.toString();
                            System.out.println("PAROLA GIOCATORE 2: " + sb);
                            giocatore2Good = true;
                            break turnoGiocatore2;
                        }
                    }
                }
            }
            if (!giocatore2Good) {
                System.out.println("GIOCATORE 2: PAROLE FINITE");
            }
            System.out.println("GIOCATORE 1: " + giocatore1Good + "\t\t\tGIOCATORE 2: " + giocatore2Good);
            if (!giocatore1Good && !giocatore2Good) {
                return -1; // parità
            }
            if (giocatore1Good && !giocatore2Good) {
                if (first == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
    }

    public static boolean haLettereUniche(String parola) {
        Set<Character> lettere = new HashSet<>();
        for (int i = 0; i < parola.length(); i++) {
            char lettera = parola.charAt(i);
            // se la lettera è già nel set, vuol dire che è duplicata
            if (!lettere.add(lettera)) {
                return false;
            }
        }
        return true;
    }
}
