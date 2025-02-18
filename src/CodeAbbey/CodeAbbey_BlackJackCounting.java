package CodeAbbey;
import java.util.Scanner;
public class CodeAbbey_BlackJackCounting {
    public static void main(String[] args) {

//        The game of Blackjack has very simple rules: players should take cards one by one trying to collect more points than opponents,
//        but not exceeding 21 (refer Wikipedia for complete rules).
//
//        The deck contains all cards from 2 to 10 inclusive, which are counted according to their value, also Kings,
//        Queens and Jacks which cost 10 points each and also Aces, which could be counted as 1 or 11 points, whatever is better.
//        Let us learn the programming of scoring algorithm for such game.
//
//        Input data will contain the number of test-cases in the first line.
//        Then test-cases will follow on separate lines. Each test-case consists of several cards expressed with symbols:
//        2, 3, 4, 5, 6, 7, 8, 9,
//        T, J, Q, K - for 10, Jack, Queen, King,
//        A - for Ace.
//        Answer should contain the number of points in each test-case, not exceeding 21 - or the word Bust if the total is greater than 21 (i.e. player immediately loss).
//
//        Example:
//        input data:
//        4
//        A T
//        2 K 4
//        3 A Q 8
//        A 3 3 3 A
//
//        answer:
//        21 16 Bust 21

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j < n; j++) {
            int num = 0, assi = 0;
            String stringa = scanner.nextLine();
            String[] lettere = stringa.split(" ");

            for (String s : lettere) {
                if (s.equals("T") || s.equals("J") || s.equals("Q") || s.equals("K")) {
                    num += 10;
                } else if (s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") ||
                        s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9")) {
                    num += Integer.parseInt(s);
                } else if (s.equals("A")) {
                    assi++;
                    num += 11;
                }
            }
            while (num > 21 && assi > 0) {
                num -= 10;
                assi--;
            }
            if (num > 21) {
                System.out.print("Bust ");
            } else {
                System.out.print(num + " ");
            }
        }
    }
}