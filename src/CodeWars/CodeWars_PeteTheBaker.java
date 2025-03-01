package CodeWars;
import java.util.*;
public class CodeWars_PeteTheBaker {
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

