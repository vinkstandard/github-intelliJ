package AdventOfCode2025;

import java.io.*;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2025\\day5.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> id = new ArrayList<>();
        List<String> righe = new ArrayList<>();
        boolean flag = false;

        while ((st = br.readLine()) != null) {
            if (st.isEmpty()) {
                flag = true;
                continue;
            }
            if (flag) {
                righe.add(st);
            } else {
                id.add(st);
            }
        }

        System.out.println("Risultato Parte 1: " + calcolaParte1(id, righe));
        System.out.println("Risultato Parte 2: " + calcolaParte2(id));
    }

    public static int calcolaParte1(List<String> ids, List<String> righe) {
        int totale = 0;
        for (String rigo : righe) {
            for (String id : ids) {
                String[] idRange = id.split("-");
                long checkId = Long.parseLong(rigo);
                if (checkId >= Long.parseLong(idRange[0]) && checkId <= Long.parseLong(idRange[1])) {
                    totale++;
                    break;
                }
            }
        }
        return totale;
    }

    public static long calcolaParte2(List<String> ids) {
        long totale = 0;
        // ordiniamo la lista in base al primo numero del range
        ids.sort((id1, id2) -> {
            long min1 = Long.parseLong(id1.split("-")[0]);
            long min2 = Long.parseLong(id2.split("-")[0]);
            return Long.compare(min1, min2);
        });
        // System.out.println(ids);

        boolean azione = true;
        while (azione) {
            azione = false;
            for (int j = 0; j < ids.size(); j++) {
                String idCheck = ids.get(j);
                long minCheck = Long.parseLong(idCheck.split("-")[0]), maxCheck = Long.parseLong(idCheck.split("-")[1]);

                if (j + 1 < ids.size()) {
                    String id = ids.get(j + 1);
                    long min = Long.parseLong(id.split("-")[0]), max = Long.parseLong(id.split("-")[1]);
                    // controlliamo due range alla volta, controllando il range minimo del secondo numero, se è <= del range massimo del primo numero, allora si possono unire
                    // funziona solo percché ordiniamo la lista all'inizio
                    if (min <= maxCheck + 1) {
                        long nuovoMax = Math.max(maxCheck, max);
                        String nuovoId = minCheck + "-" + nuovoMax;
                        // System.out.println("fusione, uniamo " + idCheck + " | " + id + " nuovo id: " + nuovoId);
                        ids.set(j + 1, nuovoId);
                        ids.remove(j);
                        azione = true;
                        break;
                    }
                }
            }
        }

        for (String id : ids) {
            String[] split = id.split("-");
            long min = Long.parseLong(split[0]), max = Long.parseLong(split[1]) + 1;
            totale += (max - min);
        }
        return totale;
    }
}
