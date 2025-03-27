package CodeWars._7kyu;
import java.util.*;

public class CodeWars_Isograms {
    public static void main(String[] args) {
        //    https://www.codewars.com/kata/54ba84be607a92aa900000f1/train/java
//            "Dermatoglyphics" --> true
//            "aba" --> false
//            "moOse" --> false (ignore letter case)
        String s = "moOse";
        System.out.println(isIsogram(s));
    }

public static boolean  isIsogram(String str) {

        HashMap<Character,Integer> mappa = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = Character.toLowerCase(str.charAt(i));
            if(mappa.containsKey(c)){
                return false;
            }
            else{
                mappa.put(c , 0);
            }
        }
        return true;
    }
}
