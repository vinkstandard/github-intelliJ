package CodeWars._5kyu;
import java.util.*;
public class CodeWars_PeteTheBaker {
    public static void main(String[] args) {

        HashMap<String,Integer> ricetta = new HashMap<>();
        HashMap<String,Integer> available = new HashMap<>();

        ricetta.put("flour" ,500);ricetta.put("sugar", 200);ricetta.put("eggs",1);
        available.put("flour" ,1200);available.put("sugar", 1200);available.put("eggs",5);available.put("milk", 200);
        System.out.println(cakes(ricetta,available));
    }
    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        int nTorte = 0;
        // le hashmap sono mutabli a differenza delle map, quindi mi faccio una copia di available così da porterla modificare.
        HashMap<String,Integer> available1 = new HashMap<>(available);

        // check per controllare se ho gli ingredienti e la quantità necessaria
        for(String s : recipe.keySet()){
            if(!available1.containsKey(s) || available1.get(s) < recipe.get(s)){
                return nTorte;
            }
        }
        boolean possibile = true;
        while(possibile){
            for(String s : recipe.keySet()){
                int rimozione = available1.get(s) - recipe.get(s);
                available1.put(s, rimozione);
            }
            nTorte++;
            // check per controllare se possiamo continuare a sfornare torte:
            for(String s : recipe.keySet()){
                if(available1.get(s) < recipe.get(s)){
                    possibile = false;
                    break;
                }
            }
        }
        return nTorte;
    }
}

