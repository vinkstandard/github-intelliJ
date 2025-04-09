package CodeWars._6kyu;

public class CodeWars_SumOfDigitDigitalRoot {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/541c8630095125aba6000c00
//        Digital root is the recursive sum of all the digits in a number.
//        Given n, take the sum of the digits of n. If that value has more than one digit,
//        continue reducing in this way until a single-digit number is produced. The input will be a non-negative integer.
//
//        Examples
//        16  -->  1 + 6 = 7
//        942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
//        132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
//        493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
        int n = 493193;
        System.out.println(digital_root(n));
    }

    public static int digital_root(int n) {

        String s = String.valueOf(n);
        while (s.length() != 1) {
            int numero = 0;
            for (int i = 0; i < s.length(); i++) {
                numero += Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            s = String.valueOf(numero);
        }
        return Integer.parseInt(s);
    }
}
