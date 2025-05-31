package CodeWars._8kyu;

public class CodeWars_Neutralization {
    public static void main(String[] args) {


//        https://www.codewars.com/kata/65128732b5aff40032a3d8f0
//        Given two strings comprised of + and -, return a new string which shows how the two strings interact in the following way:
//
//        When positives and positives interact, they remain positive.
//        When negatives and negatives interact, they remain negative.
//        But when negatives and positives interact, they become neutral, and are shown as the number 0.
//        Worked Example
//        ("+-+", "+--") ➞ "+-0"
//        # Compare the first characters of each string, then the next in turn.
//        # "+" against a "+" returns another "+".
//        # "-" against a "-" returns another "-".
//        # "+" against a "-" returns "0".
//        # Return the string of characters.
//        Examples
//           ("--++--", "++--++") ➞ "000000"
//           ("-+-+-+", "-+-+-+") ➞ "-+-+-+"
//           ("-++-", "-+-+") ➞ "-+00"
//        Notes: The two strings will be the same length.

        String s1 = "-++-", s2 = "-+-+";
        System.out.println(neutralise(s1,s2));
    }
    public static String neutralise(String s1, String s2) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                sb.append(s1.charAt(i));
            }else{
                sb.append("0");
            }
        }

        return sb.toString();
    }
    }
