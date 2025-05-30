package CodeWars._8kyu;

import java.math.BigInteger;

public class CodeWars_TwiceAsOld {
    public static void main(String[] args) {


//        https://www.codewars.com/kata/5b853229cfde412a470000d0
//        Your function takes two arguments:
//
//        current father's age (years)
//        current age of his son (years)
//        Сalculate how many years ago the father was twice as old as his son
//        (or in how many years he will be twice as old).
//        The answer is always greater or equal to 0, no matter if it was in the past or it is in the future.

//        doTest(30, 0, 30);
//        doTest(30, 7, 16);
//        doTest(45, 30, 15);
//        doTest(36, 7, 22);
//        doTest(55, 30, 5);
//        doTest(42, 21, 0);
//        doTest(22, 1, 20);
//        doTest(29, 0, 29);

        int papa = 42;
        int figlio = 21;
        System.out.println("Eta padre: " + papa + "\nEtà figlio: " + figlio + "\nDifferenza: "  + twiceAsOld(papa,figlio));

    }



    public static int twiceAsOld(int dadYears, int sonYears) {

        if(sonYears == 0) return dadYears;
        return Math.abs(dadYears - (sonYears * 2));




    }
}
