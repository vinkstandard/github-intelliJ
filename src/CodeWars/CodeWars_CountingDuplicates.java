package CodeWars;
import java.util.*;

public class CodeWars_CountingDuplicates {
    public static void main(String[] args) {
        // https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/java
//        "abcde" -> 0 # no characters repeats more than once
//        "aabbcde" -> 2 # 'a' and 'b'
//        "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
//        "indivisibility" -> 1 # 'i' occurs six times
//        "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
//        "aA11" -> 2 # 'a' and '1'
//        "ABBA" -> 2 # 'A' and 'B' each occur twice

        String text = "aA11";
        System.out.println(duplicateCount(text));
    }

    public static int duplicateCount(String text) {
        HashMap<String, Integer> mappa = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (!mappa.containsKey(String.valueOf(c))) {
                mappa.put(String.valueOf(c), 1);
            } else {
                mappa.put(String.valueOf(c), mappa.get(String.valueOf(c)) + 1);
            }
        }
        int count = 0;
        for (int n : mappa.values()) {
            if (n > 1) {
                count++;
            }
        }
        return count;
    }
}
