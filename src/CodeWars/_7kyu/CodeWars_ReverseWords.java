package CodeWars._7kyu;

public class CodeWars_ReverseWords {
    public static void main(String[] args) {
        // https://www.codewars.com/kata/5259b20d6021e9e14c0010d4/java
        //  "  double  spaced  words  " == "  elbuod  decaps  sdrow  "
        //  "The quick brown fox jumps over the lazy dog." == "ehT kciuq nworb xof spmuj revo eht yzal .god"
        //  "apple" == "elppa"
        String original = "apple";
        System.out.println(reverseWords(original));
    }

    public static String reverseWords(final String original) {

        StringBuilder finale = new StringBuilder();
        StringBuilder building = new StringBuilder();

        if (original.length() == 1) {
            return original;
        }
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (c != ' ') {
                building.append(c);
            } else {
                if (!building.isEmpty()) {
                    finale.append(building.reverse());
                    building.delete(0, building.length());
                }
                finale.append(c);
            }
        }
        if (!building.isEmpty()) {
            finale.append(building.reverse());
        }
        return finale.toString();
    }
}