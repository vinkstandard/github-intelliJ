package CodeWars;
import java.util.*;

public class CodeWars_HumanReadableDurationFormat {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/java
//* For seconds = 62, your function should return   "1 minute and 2 seconds"
//* For seconds = 3662, your function should return "1 hour, 1 minute and 2 seconds"
//        33320430 = 1:20:15:40:30
        int secondi = 62;
        System.out.println(formatDuration(secondi));

    }
    public static String formatDuration(int seconds) {

        if(seconds == 1){
            return "1 second";
        }
        else if(seconds == 0){
            return "now";
        }
        int secondi = seconds % 60;
        int minuti = (seconds / 60) % 60;
        int ore = (seconds / 3600) % 24;
        int giorni = (seconds / 86400) % 365;
        int anni = seconds / (86400 * 365);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> dataConZero = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        // casi plurale
        if(anni == 1){dataConZero.add(anni + " year");}else{dataConZero.add(anni + " years");}
        if(giorni == 1){dataConZero.add(giorni + " day");}else{dataConZero.add(giorni + " days");}
        if(ore == 1){dataConZero.add(ore + " hour");}else{dataConZero.add(ore + " hours");}
        if(minuti == 1){dataConZero.add(minuti + " minute");}else{dataConZero.add(minuti + " minutes");}
        if(secondi == 1){dataConZero.add(secondi + " second");}else{dataConZero.add(secondi + " seconds");}

        for (String s : dataConZero) {
            char c = s.charAt(0);
            int num = c - '0';
            if (num != 0) {
                data.add(s);
            }
        }
        for (int i = 0; i < data.size(); i++) {
            if (i > 0) { // se non siamo alla prima stringa
                sb.append(i == data.size() - 1 ? " and " : ", "); // se siamo all'ultimo indice, invece che la virgola piazza "and"
            }
            sb.append(data.get(i));
        }
        System.out.println(dataConZero);
        return sb.toString();
    }
}
