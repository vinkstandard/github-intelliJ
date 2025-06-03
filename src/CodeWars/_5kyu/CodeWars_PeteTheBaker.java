package CodeWars._5kyu;
import java.util.*;
public class CodeWars_PeteTheBaker {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/525c65e51bf619685c000059
//
//        Pete likes to bake some cakes. He has some recipes and ingredients. Unfortunately he is not good in maths.
//        Can you help him find out, how many cakes he could bake considering his recipes?
//        Write a function cakes(), which takes the recipe (object) and the available ingredients (also an object)
//        and returns the maximum number of cakes Pete can bake (integer).
//        For simplicity there are no units for the amounts (e.g. 1 lb of flour or 200 g of sugar are simply 1 or 200).
//        Ingredients that are not present in the objects, can be considered as 0.
//
//        Examples:
//
//        cakes({flour: 500, sugar: 200, eggs: 1}, {flour: 1200, sugar: 1200, eggs: 5, milk: 200});  must return 2
//        cakes({apples: 3, flour: 300, sugar: 150, milk: 100, oil: 100}, {sugar: 500, flour: 2000, milk: 2000}); must return 0

        HashMap<String, Integer> ricetta = new HashMap<>();
        HashMap<String, Integer> available = new HashMap<>();

        ricetta.put("flour", 500);
        ricetta.put("sugar", 200);
        ricetta.put("eggs", 1);
        available.put("flour", 1200);
        available.put("sugar", 1200);
        available.put("eggs", 5);
        available.put("milk", 200);
        System.out.println(cakes(ricetta, available));
    }

    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        int nTorte = 0;
        // le hashmap sono mutabli a differenza delle map, quindi mi faccio una copia di available così da poterla modificare.
        HashMap<String, Integer> available1 = new HashMap<>(available);

        // check per controllare se ho gli ingredienti e la quantità necessaria
        for (String s : recipe.keySet()) {
            if (!available1.containsKey(s) || available1.get(s) < recipe.get(s)) {
                return nTorte;
            }
        }
        boolean possibile = true;
        while (possibile) {
            for (String s : recipe.keySet()) {
                int rimozione = available1.get(s) - recipe.get(s);
                available1.put(s, rimozione);
            }
            nTorte++;
            // check per controllare se possiamo continuare a sfornare torte:
            for (String s : recipe.keySet()) {
                if (available1.get(s) < recipe.get(s)) {
                    possibile = false;
                    break;
                }
            }
        }
        return nTorte;
    }
}

