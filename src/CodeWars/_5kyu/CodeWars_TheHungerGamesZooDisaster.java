package CodeWars._5kyu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CodeWars_TheHungerGamesZooDisaster {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/5902bc7aba39542b4a00003d/train/java
        System.out.println(Arrays.toString(whoEatsWho("fox,bug,chicken,grass,sheep")));
        System.out.println(Arrays.toString(whoEatsWho("giraffe,leaves,leaves,leaves,bear,bug,leaves,leaves,panda")));

//        antelope eats grass
//        big-fish eats little-fish
//        bug eats leaves
//        bear eats big-fish
//        bear eats bug
//        bear eats chicken
//        bear eats cow
//        bear eats leaves
//        bear eats sheep
//        chicken eats bug
//        cow eats grass
//        fox eats chicken
//        fox eats sheep
//        giraffe eats leaves
//        lion eats antelope
//        lion eats cow
//        panda eats leaves
//        sheep eats grass
    }

    public static String[] whoEatsWho(final String zoo) {

        Map<String, List<String>> mappa = Map.ofEntries(
                Map.entry("antelope", List.of("grass")),
                Map.entry("big-fish", List.of("little-fish")),
                Map.entry("bug", List.of("leaves")),
                Map.entry("bear", List.of("big-fish", "bug", "chicken", "cow", "leaves", "sheep")),
                Map.entry("chicken", List.of("bug")),
                Map.entry("cow", List.of("grass")),
                Map.entry("fox", List.of("chicken", "sheep")),
                Map.entry("giraffe", List.of("leaves")),
                Map.entry("lion", List.of("antelope", "cow")),
                Map.entry("panda", List.of("leaves")),
                Map.entry("sheep", List.of("grass"))
        );
        List<String> animali = new ArrayList<>(List.of(zoo.split(",")));
        List<String> risultato = new ArrayList<>(List.of(zoo));

        boolean flag;
        do {
            flag = false;
            for (int indice = 0; indice < animali.size(); indice++) {
                String animaleAttuale = animali.get(indice);
                if (mappa.containsKey(animali.get(indice))) {
                    // mangiata a sinistra
                    if (indice - 1 >= 0 && mappa.get(animaleAttuale).contains(animali.get(indice - 1))) {
                        risultato.add(animaleAttuale + " eats " + animali.get(indice - 1));
                        System.out.println("DEBUG--- appeso: " + animaleAttuale + " eats " + animali.get(indice - 1));
                        animali.remove(indice - 1);
                        flag = true;
                        break;
                    }
                    // mangiata a destra
                    else if (indice + 1 < animali.size() && mappa.get(animaleAttuale).contains(animali.get(indice + 1))) {
                        risultato.add(animaleAttuale + " eats " + animali.get(indice + 1));
                        System.out.println("DEBUG--- appeso: " + animaleAttuale + " eats " + animali.get(indice + 1));
                        animali.remove(indice + 1);
                        flag = true;
                        break;
                    }
                }
            }
        } while (flag);
        // aggiungiamo gli animali che sono rimasti
        risultato.add(animali.toString().replaceAll("[\\[\\]\\s]", ""));
        return risultato.toArray(String[]::new);
    }
}
