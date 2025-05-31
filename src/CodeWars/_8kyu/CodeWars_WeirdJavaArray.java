package CodeWars._8kyu;

import java.util.*;

public class CodeWars_WeirdJavaArray {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/6607fc50c6494c000f1a08fc
//        import java.util.*;
//
//        class Codewarrior {
//            public static List<Integer>[] arrayOfLists = new List<Integer>[] {
//                    Arrays.asList(1, 2, 3),
//                    Arrays.asList(4, 5, 6),
//                    Arrays.asList(7, 8, 9),
//            };
//        }
//        However, this code does not compile :(
//
//        Can you fix the code ?
//
//        arrayOfLists should hold the 3 lists shown above, (1, 2, 3), (4, 5, 6), (7, 8, 9).


    }
    @SuppressWarnings("unchecked")
    public static List<Integer>[] arrayOfLists = (List<Integer>[]) new List[] {
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9),
    };

}
