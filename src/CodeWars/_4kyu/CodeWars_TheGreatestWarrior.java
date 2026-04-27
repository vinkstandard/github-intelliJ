package CodeWars._4kyu;

import java.util.List;

public class CodeWars_TheGreatestWarrior {
    public static void main(String[] args) {

        Warrior tu = new Warrior();

//        Completing a battle against an enemy with the same level as your warrior will be worth 10 experience points.
//        Completing a battle against an enemy who is one level lower than your warrior will be worth 5 experience points.
//        Completing a battle against an enemy who is two levels lower or more than your warrior will give 0 experience points.
//        Completing a battle against an enemy who is one level higher or more than your warrior will accelarate your experience gaining.
//        The greater the difference between levels, the more experinece your warrior will gain. The formula is 20 * diff * diff where diff equals the difference in levels between the enemy and your warrior.
//        However, if your warrior is at least one rank lower than your enemy, and at least 5 levels lower, your warrior cannot fight against an enemy that strong and must instead return "You've been defeated".

//        Every successful battle will also return one of three responses: "Easy fight", "A good fight", "An intense fight".
//        Return "Easy fight" if your warrior is 2 or more levels higher than your enemy's level.
//        Return "A good fight" if your warrior is either 1 level higher or equal to your enemy's level.
//        Return "An intense fight" if your warrior's level is lower than the enemy's level.

        System.out.println("Il giocatore è livello [" + tu.level() + "] ed è rank [" + tu.rank() + "]");


    }
}

class Warrior {
    private final List<String> ranks = List.of("Pushover", "Novice", "Fighter", "Warrior", "Veteran", "Sage", "Elite", "Conqueror", "Champion", "Master", "Greatest");

    private List<String> achievements;
    private int esperienzaAttuale;
    String rankAttuale;

    public Warrior() {
        this.esperienzaAttuale = 100;
        this.rankAttuale = ranks.get(0);
    }
    public int level(){ return this.esperienzaAttuale / 100; }
    public String rank(){ return this.rankAttuale; }
    public int experience(){ return this.esperienzaAttuale; }

    public String battle(int livelloAvversario){
        if(livelloAvversario > 100 || livelloAvversario < 1) return "Invalid level";

        String rankAvversario = ranks.get(livelloAvversario / 10);

        if(ranks.indexOf(this.rank()) < ranks.indexOf(rankAvversario)){
            int differenzaLivello = livelloAvversario - this.level();
            if(differenzaLivello >= 5){
                return "You've been defeated";
            }

        }
        return "ciaoo";
        // da fare
    }
    public void aggiornaRank(Warrior warrior){
        int indiceRank = this.level() / 10;
        this.rankAttuale = switch (indiceRank) {
            case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> ranks.get(indiceRank);
            case 10 -> ranks.get(10);
            default -> ranks.get(0);
        };
    }
    public List<String> achievements(){
        return null;
        // da fare
    }
    public String training(String descrizione, int puntiEsperienza, int livelloMinimoRichiesto){
        return descrizione;
        // da fare
    }



    public void cheat(Warrior cheater){
        this.esperienzaAttuale = 1000;
        aggiornaRank(cheater);
    }






}
