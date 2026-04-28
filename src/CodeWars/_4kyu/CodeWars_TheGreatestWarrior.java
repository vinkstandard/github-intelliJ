package CodeWars._4kyu;

import java.util.ArrayList;
import java.util.List;

public class CodeWars_TheGreatestWarrior {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/5941c545f5c394fef900000c/train/java

        Warrior guerriero = new Warrior();
        System.out.println("Il giocatore è livello [" + guerriero.level() + "]");
        System.out.println("Il giocatore ha [" + guerriero.experience() + "] esperienza");
        System.out.println("Il giocatore è rank [" + guerriero.rank() + "]");
        System.out.println("Achievement del giocatore: {" + guerriero.achievements() + "}");
        System.out.println("Risultato dell'allenamento: " + guerriero.training("Sconfitto Chuck Norris", 9000, 1));
        System.out.println("Il giocatore ha [" + guerriero.experience() + "] esperienza");
        System.out.println("Il giocatore è livello [" + guerriero.level() + "]");
        System.out.println("Il giocatore è rank [" + guerriero.rank() + "]");
        System.out.println("Risultato battaglia: " + guerriero.battle(90));
        System.out.println("Il giocatore ha [" + guerriero.experience() + "] esperienza");
        System.out.println("Achievement del giocatore: {" + guerriero.achievements() + "}");
    }
}

class Warrior {
    private final List<String> ranks = List.of("Pushover", "Novice", "Fighter", "Warrior", "Veteran", "Sage", "Elite", "Conqueror", "Champion", "Master", "Greatest");
    private List<String> achievements = new ArrayList<>();
    private int esperienzaAttuale;
    String rankAttuale;

    public Warrior() {
        this.esperienzaAttuale = 100;
        this.rankAttuale = ranks.get(0);
    }
    public int level(){ return this.esperienzaAttuale / 100; }
    public String rank(){ return this.rankAttuale; }
    public int experience(){ return this.esperienzaAttuale; }
    public List<String> achievements(){ return this.achievements; }

    public String battle(int livelloAvversario) {

        if (livelloAvversario > 100 || livelloAvversario < 1) return "Invalid level";
        String rankAvversario = ranks.get(livelloAvversario / 10);
        int differenzaLivello = livelloAvversario - this.level();
        if (ranks.indexOf(this.rank()) < ranks.indexOf(rankAvversario) && differenzaLivello >= 5)
            return "You've been defeated";

        if (differenzaLivello == 0) {
            aggiornaRank(10);
            return "A good fight";
        } else if (differenzaLivello == -1) {
            aggiornaRank(5);
            return "A good fight";
        } else if (differenzaLivello <= -2) {
            return "Easy fight";
        } else {
            aggiornaRank(20 * differenzaLivello * differenzaLivello);
            return "An intense fight";
        }

    }

    public void aggiornaRank(int esperienzaRicevuta) {
        if (this.esperienzaAttuale + esperienzaRicevuta > 10000) {
            this.esperienzaAttuale = 10000;
        } else {
            this.esperienzaAttuale += esperienzaRicevuta;
        }
        int indiceRank = this.level() / 10;
        this.rankAttuale = switch (indiceRank) {
            case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> ranks.get(indiceRank);
            case 10 -> ranks.get(10);
            default -> ranks.get(0);
        };
    }

    public String training(String descrizione, int puntiEsperienza, int livelloMinimoRichiesto) {
        if (this.level() < livelloMinimoRichiesto) {
            return "Not strong enough";
        } else {
            this.achievements.add(descrizione);
            aggiornaRank(puntiEsperienza);
            return descrizione;
        }
    }
}
