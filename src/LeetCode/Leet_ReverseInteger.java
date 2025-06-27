package LeetCode;

public class Leet_ReverseInteger {
    public static void main(String[] args) {

//        Given a signed 32-bit integer x, return x with its digits reversed.
//        If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//
//        Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//
//        Example 1:
//
//        Input: x = 123
//        Output: 321
//        Example 2:
//
//        Input: x = -123
//        Output: -321
//        Example 3:
//
//        Input: x = 120
//        Output: 21
//
//        -231 <= x <= 231 - 1

        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1_534_236_469));

    }
    public static int reverse(int x) {

        StringBuilder sb = new StringBuilder(String.valueOf(x)).reverse();
        int num;
        try {
            if (sb.toString().endsWith("-")) {
                num = Integer.parseInt(sb.deleteCharAt(sb.length() - 1).toString());
                return -Math.abs(num);
            } else {
                num = Integer.parseInt(sb.toString());
                return num;
            }
        }catch (NumberFormatException e){
            return 0;
        }
    }
}
