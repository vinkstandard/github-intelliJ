package CodeWars;
import java.util.*;
public class CodeWars_HexStringToRGB {
    public static HashMap<String, Integer> hexStringToRGB(String hex) {
        // rimuove #
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }

        // converte i valori hex in numeri interi usando la funzione built in di java
        // l'end della substring non è inclusivo quindi si ferma sempre al numero prima

        // i primi due caratteri 0-1
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        // il terzo e il quarto 2-3
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        // il quinto e il sesto 4-5
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        // creo una mappa per l'export
        HashMap<String, Integer> map = new HashMap<>();
        map.put("r", r);
        map.put("g", g);
        map.put("b", b);
        return map;
    }
}
