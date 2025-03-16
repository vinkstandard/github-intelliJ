package CodeWars;

import java.util.*;


public class CodeWars_BuildTower {
    public static void main(String[] args) {

        int nFloors = 10;
        System.out.println(Arrays.toString(towerBuilder(nFloors)));
    }

    public static String[] towerBuilder(int nFloors){

        ArrayList<String> torre = new ArrayList<>();
        int conto = 0;
        while (torre.size() != nFloors) {
            StringBuilder sb = new StringBuilder();
            if (torre.isEmpty()) {
                torre.add("*");
                continue;
            }
            sb.append("*").append(torre.get(conto++)).append("*");
            torre.add(sb.toString());
        }
        // aggiungo gli spazi;
        int aggiunta = 1;
        for (int i = torre.size() - 2; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            sb.append(" ".repeat(aggiunta)).append(torre.get(i)).append(" ".repeat(aggiunta));
            torre.set(i, sb.toString());
            aggiunta++;
        }
        // per visualizzazione debug
        for (String s : torre) {
            System.out.println(s);
        }
        return torre.toArray(new String[0]);
    }
}
