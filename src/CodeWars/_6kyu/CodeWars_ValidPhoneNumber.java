package CodeWars._6kyu;
import java.util.regex.*;

public class CodeWars_ValidPhoneNumber {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/525f47c79f2f25a4db000025
//        Write a function that accepts a string, and returns true if it is in the form of a phone number.
//        Assume that any integer from 0-9 in any of the spots will produce a valid phone number.
//        Only worry about the following format:
//        (123) 456-7890 (don't forget the space after the close parentheses)
//
//        Examples:
//        "(123) 456-7890"  => true
//        "(1111)555 2345"  => false
//        "(098) 123 4567"  => false
//        "abc(123) 456-7890"  => false

        String[] numeri = {"(123) 456-7890", "(1111)555 2345", "(098) 123 4567", "abc(123) 456-7890"};
        for (String numero : numeri) {
            System.out.println(validPhoneNumber(numero));
        }
    }

    public static boolean validPhoneNumber(String phoneNumber) {

        Pattern pattern = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }
}
