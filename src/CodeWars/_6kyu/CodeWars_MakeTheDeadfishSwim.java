package CodeWars._6kyu;

import java.util.*;

public class CodeWars_MakeTheDeadfishSwim {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/51e0007c1f9378fa810002a9
//        Create a parser to interpret and execute the Deadfish language.
//
//        Deadfish operates on a single value in memory, which is initially set to 0.
//
//        It uses four single-character commands:
//
//        i: Increment the value
//        d: Decrement the value
//        s: Square the value
//        o: Output the value to a result array
//        All other instructions are no-ops and have no effect.
//
//        Examples
//        Program "iiisdoso" should return numbers [8, 64].
//        Program "iiisdosodddddiso" should return numbers [8, 64, 3600]

        System.out.println(Arrays.toString(parse("iiisdoso")));
        System.out.println(Arrays.toString(parse("iiisdosodddddiso")));

    }

    public static int[] parse(String data) {

        int numeroBase = 0;
        char[] comandi = data.toCharArray();
        ArrayList<Integer> outputArrayList = new ArrayList<>();
        for(char c : comandi){
            switch (c){
                case 'i' -> numeroBase++;
                case 'd' -> numeroBase--;
                case 's' -> numeroBase *= numeroBase;
                case 'o' -> outputArrayList.add(numeroBase);
            }
        }
        return outputArrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}
