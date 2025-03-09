package CodeWars;

import java.util.*;

public class CodeWars_MultiplesOf3And5 {
    public static void main(String[] args) {
        //        https://www.codewars.com/kata/514b92a657cdc65150000006/train/java
//        If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
//        Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
//        Note: If the number is a multiple of both 3 and 5, only count it once.


        int num = 10;
        System.out.println(solution(num));

    }

    public static int solution(int number) {

        ArrayList<Integer> lista = new ArrayList<>();
        if(number <= 0){
            return 0;
        }
        number -= 1;

        while(number > 0){
            if(number % 3 == 0){
                lista.add(number);
                number--;
                continue;
            }
            if(number % 5 == 0){
                lista.add(number);
                number--;
                continue;
            }
            number--;
        }
        int totale = 0;
        if(lista.isEmpty()){
            return totale;
        }else{
            for(int n : lista){
                totale += n;
            }
            return totale;
        }
    }
}
