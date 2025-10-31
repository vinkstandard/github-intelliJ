package CodeWars._7kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeWars_FindTheVowels {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5680781b6b7c2be860000036
//        We want to know the index of the vowels in a given word, for example,
//        there are two vowels in the word super (the second and fourth letters).
//        So given a string "super", we should return a list of [2, 4].
//
//        Some examples:
//        Mmmm  => []
//        Super => [2,4]
//        Apple => [1,5]
//        YoMama -> [1,2,4,6]
//        NOTES
//        Vowels in this context refers to: a e i o u y (including upper case)
//        This is indexed from [1..n] (not zero indexed!)
        System.out.println(Arrays.toString(vowelIndices("apple")));
    }
    public static int[] vowelIndices(String word){
        List<Integer> lista = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            char c = Character.toLowerCase(word.charAt(i));
            if(isVowel(c)) lista.add(i + 1);
        }
        return lista.stream().mapToInt(Integer::intValue).toArray();

    }
    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }
}
