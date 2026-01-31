package CodeWars._6kyu;

public class CodeWars_ReplaceWithAlphabetPosition {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/546f922b54af40e1e90001da/java
        System.out.println(alphabetPosition("The sunset sets at twelve o' clock."));
    }

    static String alphabetPosition(String text) {
        String gaming = "abcdefghijklmnopqrstuvwxyz", nums = "";
        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) nums += gaming.indexOf(Character.toLowerCase(c)) + 1 + " ";
        }
        return nums;
    }
}
