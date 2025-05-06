package CodeWars._6kyu;

public class CodeWars_IntroToArt {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5d7d05d070a6f60015c436d1/train/java
//        Help prepare for the entrance exams to art school.
//
//        It is known in advance that this year, the school chose the symmetric letter “W” as the object for the image,
//        and the only condition for its image is only the size that is not known in advance, so as training,
//        you need to come up with a way that accurately depicts the object.
//        Write a function that takes an integer as height and returns a list of strings with a line-by-line image of the object.
//        Below is an example function:
//
//        # height = 3 should return:
//          [
//                "*   *   *",
//                " * * * * ",
//                "  *   *  "
//          ]
//
//        # height = 5 should return:
//          [
//                "*       *       *",
//                " *     * *     * ",
//                "  *   *   *   *  ",
//                "   * *     * *   ",
//                "    *       *    "
//          ]
//        Return an empty list for height < 2.

        int[] altezze = {3, 5, 2, 0, 10};
        for (int i = 0; i < altezze.length; i++) {
            String[] w = getW(altezze[i]);
            if (w.length != 0) {
                System.out.println("------------------GRAFICO NUMERO " + (i + 1) + " ------------------");
                for (String rigo : w) {
                    System.out.println(rigo);
                }
            }
        }

    }

    public static String[] getW(int height) {

        if (height < 2) return new String[0]; // array vuoto
        int larghezza = 4 * height - 3;
        String[] risultato = new String[height];

        for (int i = 0; i < height; i++) {
            StringBuilder riga = new StringBuilder(" ".repeat(larghezza));
            riga.setCharAt(i, '*');
            riga.setCharAt(2 * height - 2 - i, '*');
            riga.setCharAt(2 * height - 2 + i, '*');
            riga.setCharAt(4 * height - 4 - i, '*');

            risultato[i] = riga.toString();
        }

        return risultato;
    }
}