package CodeWars;
import java.util.List;
import java.util.regex.*;

public class CodeWars_CountTheSmileyFaces {
    public static int countSmileys(List<String> arr) {
        if (arr.isEmpty()) {
            return 0;
        }
        String regex = "[:;][~-]?[)D]";
        int totale = 0;
        Pattern pattern = Pattern.compile(regex);
        for (String s : arr) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()) {
                totale++;
            }
        }
        return totale;
    }
}


