package CodeWars._6kyu;

public class CodeWars_ValidateCreditCardNumber {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5418a1dd6d8216e18a0012b2
//        In this Kata, you will implement the Luhn Algorithm, which is used to help validate credit card numbers.
//
//        Given a positive integer of up to 16 digits, return true if it is a valid credit card number, and false if it is not.
//
//        Here is the algorithm:
//
//        Double every other digit, scanning from right to left, starting from the second digit (from the right).
//
//        Another way to think about it is: if there are an even number of digits, double every other digit starting with the first;
//        if there are an odd number of digits, double every other digit starting with the second:
//
//        1714 ==> [1*, 7, 1*, 4] ==> [2, 7, 2, 4]
//
//        12345 ==> [1, 2*, 3, 4*, 5] ==> [1, 4, 3, 8, 5]
//
//        891 ==> [8, 9*, 1] ==> [8, 18, 1]
//        If a resulting number is greater than 9, replace it with the sum of its own digits (which is the same as subtracting 9 from it):
//
//        [8, 18*, 1] ==> [8, (1+8), 1] ==> [8, 9, 1]
//
//        or:
//
//        [8, 18*, 1] ==> [8, (18-9), 1] ==> [8, 9, 1]
//        Sum all of the final digits:
//
//        [8, 9, 1] ==> 8 + 9 + 1 = 18
//        Finally, take that sum and divide it by 10. If the remainder equals zero, the original credit card number is valid.
//
//        18 (modulus) 10 ==> 8 , which is not equal to 0, so this is not a valid credit card number

        System.out.println("Risultato: (" + validate("891") + ") Expected: (false)");
    }

    public static boolean validate(String n) {

        String[] nums = n.split("");

        for (int i = 0; i < nums.length; i++) {
            int numero = Integer.parseInt(nums[i]);
            int posizioneDaDestra = nums.length - 1 - i;

            if (posizioneDaDestra % 2 == 1) {
                numero *= 2;
                if (numero > 9) numero -= 9;
            }
            nums[i] = String.valueOf(numero);
        }

        int somma = 0;
        for (String num : nums) {
            somma += Integer.parseInt(num);
        }

        return somma % 10 == 0;
    }
}
