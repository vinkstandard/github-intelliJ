package CodeWars._6kyu.CountTheErrorsInTheLogFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Soluzione {
    public static void main(String[] args) throws IOException {

        System.out.println(mapErrors());


    }
    public static LinkedHashMap<String, Integer> mapErrors() {
        try{
//          BufferedReader br = new BufferedReader(new FileReader("server.log"));
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vink\\IdeaProjects\\github-intelliJ\\src\\CodeWars\\_6kyu\\CountTheErrorsInTheLogFile\\server.log"));

            String st;
            HashMap<String,Integer> mappa = new HashMap<>();
            while ((st = br.readLine()) != null) {
                if(st.toLowerCase().startsWith("error: ")){
                    String chiave = st.toLowerCase().substring(7);
                    if(!mappa.containsKey(chiave)){
                        mappa.putIfAbsent(chiave, 1);
                    } else {
                        mappa.replace(chiave, mappa.get(chiave) + 1);
                    }

                }
            }
            return mappa.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> a,
                            LinkedHashMap::new
                    ));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
