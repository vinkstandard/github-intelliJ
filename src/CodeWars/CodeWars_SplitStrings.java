package CodeWars;

import java.util.*;


public class CodeWars_SplitStrings {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/515de9ae9dcfc28eb6000001
//        Complete the solution so that it splits the string into pairs of two characters.
//        If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').
//        Examples:
//        abc' =>  ['ab', 'c_']
//        abcdef' => ['ab', 'cd', 'ef']

        String s = "abc";
        System.out.println(Arrays.toString(solution(s)));

    }
    public static String[] solution(String s) {

        ArrayList<String> splittate = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 1){
            splittate.add(sb.charAt(0) +""+ sb.charAt(1));
            sb.deleteCharAt(0);
            sb.deleteCharAt(0);
        }
        if(sb.length() == 1){
            sb.append("_");
            splittate.add(sb.toString());
        }
        return splittate.toArray(new String[0]);
    }
}
