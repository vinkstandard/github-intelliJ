package CodeWars._7kyu;

public class CodeWars_NumberOfDecimalDigits {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/58fa273ca6d84c158e000052/train/java
//        Determine the total number of digits in the integer (n>=0) given as input to the function.
//        For example, 9 is a single digit
//        66 has 2 digits
//        128685 has 6 digits.
//        Be careful to avoid overflows/underflows.
//
//        All inputs will be valid.
        System.out.println(Digits(9));
        System.out.println(Digits(66));
        System.out.println(Digits(128685));
    }

    public static int Digits(long n) {
        return String.valueOf(n).replaceAll("[A-Za-z]", "").length();
    }
}
