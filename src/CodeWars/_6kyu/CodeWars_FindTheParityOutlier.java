package CodeWars._6kyu;
import java.util.*;

public class CodeWars_FindTheParityOutlier {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5526fc09a1bbd946250002dc/train/java
//        [2, 4, 0, 100, 4, 11, 2602, 36] -->  11 (the only odd number)
//        [160, 3, 1719, 19, 11, 13, -21] --> 160 (the only even number)
       int[] numeri = {160, 3, 1719, 19, 11, 13, -21};
       System.out.println(find(numeri));
    }
    static int find(int[] integers) {

        ArrayList<Integer> dispari = new ArrayList<>();
        ArrayList<Integer> pari = new ArrayList<>();
        for(int n : integers){
            if(n % 2 == 0){
                pari.add(n);
            }else{
                dispari.add(n);
            }
        }
        if(pari.size() > dispari.size()){
            return dispari.getFirst();
        }else{
            return pari.getFirst();
        }
    }
}
