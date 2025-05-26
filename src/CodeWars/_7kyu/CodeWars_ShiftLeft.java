package CodeWars._7kyu;

public class CodeWars_ShiftLeft {
//    https://www.codewars.com/kata/5bdc191306a8a678f6000187
//    You are given two strings. In a single move, you can choose any of them, and delete the first (i.e. leftmost) character.
//
//    For Example:
//
//    By applying a move to the string "where", the result is the string "here".
//    By applying a move to the string "a", the result is an empty string "".
//    Implement a function that calculates the minimum number of moves that should be performed to make the given strings equal.
//
//    Notes
//    Both strings consist of lowercase latin letters.
//    If the string is already empty, you cannot perform any more delete operations.

    public static void main(String[] args) {
        String a = "test", b = "west";
        System.out.println(shiftLeft(a,b));
    }
    public static int shiftLeft(String a, String b) {

        if(a.isEmpty() && !b.isEmpty()){
            return b.length();
        }
        else if(!a.isEmpty() && b.isEmpty()){
            return a.length();
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int comune = 0;

        while (i >= 0 && j >= 0 && a.charAt(i) == b.charAt(j)) {
            comune++;
            i--;
            j--;
        }

        return (a.length() - comune) + (b.length() - comune);
    }
}
