package CodeAbbey;

import java.util.Scanner;

public class CodeAbbey_DuelChances {
    public static void main(String[] args) {
//        Two friends, Alan and Bob are engaged in a deathly duel. They agreed to stand in front of each other and shoot until one of them is mortally wounded.
//
//        Since they have only one pistol, they will shoot in turns. Casting lots determined that Alan is first to fire.
//
//                Before duelling they want to get life insurance. Insurance manager then needs to determine what are their chances to die, to calculate proper insurance cost.
//
//        You are to help the manager in his calculations. You will be given the probability for both duellers to hit and hurt opponent critically with a single shot - and you asked to write a program which will tell Alan's chances to win (then Bob's chances to win could be calculated by manager himself as Alan's chances to die).
//
//        Input data will contain the number of test-cases in first line.
//                Next lines will contain two numbers pA and pB each - the chance to kill opponent with a shot for Alan and Bob respectively, expressed in percents (so the values would be integer).
//        Answer should contain the chance for Alan to win (and for Bob to die) in percents, rounded to nearest integer. Separate several answers with spaces.
//
//                Example:
//
//        input data:
//        2
//        30 50
//        20 15
//
//        answer:
//        46 63

        // che cancro il calcolo delle probabilità

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int pA = scanner.nextInt(), pB = scanner.nextInt();
            double ppA = 1 - ((double) pA / 100); // probabilità che alan non colpisca
            double ppB = 1 - ((double) pB / 100); // probabilità che bob non colpisca
            double missanoEntrambi = ppA * ppB, hittaAlmenoUno = 1 - missanoEntrambi;
            double vittoriaAlan = ((double) pA / 100) / hittaAlmenoUno, risultatoArrotondato = Math.round(vittoriaAlan * 100);
            System.out.print((int) risultatoArrotondato + " ");
        }
    }
}
