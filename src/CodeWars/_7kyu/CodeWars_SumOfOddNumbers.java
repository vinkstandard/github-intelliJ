package CodeWars._7kyu;

public class CodeWars_SumOfOddNumbers {
    public static void main(String[] args) {
        // https://www.codewars.com/kata/55fd2d567d94ac3bc9000064/train/java
        System.out.println(rowSumOddNumbers(42));
    }

    public static int rowSumOddNumbers(int n) {
        // https://it.wikipedia.org/wiki/Teorema_di_Nicomaco
        return (int)Math.pow(n, 3);

    }
}


