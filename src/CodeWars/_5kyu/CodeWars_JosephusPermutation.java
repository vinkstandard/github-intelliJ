package CodeWars._5kyu;
import java.util.*;

public class CodeWars_JosephusPermutation {
    public static void main(String[] args) {

//   https://www.codewars.com/kata/5550d638a99ddb113e0000a2
//   This problem takes its name by arguably the most important event in the life of the ancient historian Josephus:
//   according to his tale, he and his 40 soldiers were trapped in a cave by the Romans during a siege.
//
//   Refusing to surrender to the enemy, they instead opted for mass suicide, with a twist:
//   they formed a circle and proceeded to kill one man every three, until one last man was left (and that it was supposed to kill himself to end the act).
//
//   Well, Josephus and another man were the last two and, as we now know every detail of the story
//   you may have correctly guessed that they didn't exactly follow through the original idea.
//
//   You are now to create a function that returns a Josephus permutation,
//   taking as parameters the initial array/list of items to be permuted as if they were in a circle and counted out every k places until none remained.
//
//   Tips and notes: it helps to start counting from 1 up to n, instead of the usual range 0 to n-1; k will always be >=1.
//
//   For example, with an array=[1,2,3,4,5,6,7] and k=3, the function should act this way.
//
//    [1,2,3,4,5,6,7] - initial sequence
//    [1,2,4,5,6,7] => 3 is counted out and goes into the result [3]
//    [1,2,4,5,7] => 6 is counted out and goes into the result [3,6]
//    [1,4,5,7] => 2 is counted out and goes into the result [3,6,2]
//    [1,4,5] => 7 is counted out and goes into the result [3,6,2,7]
//    [1,4] => 5 is counted out and goes into the result [3,6,2,7,5]
//    [4] => 1 is counted out and goes into the result [3,6,2,7,5,1]
//    [] => 4 is counted out and goes into the result [3,6,2,7,5,1,4]
//    So our final result is: [3,6,2,7,5,1,4]
//
//
        List<Integer> numerico = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<String> stringhe = Arrays.asList("C", "o", "d", "e", "W", "a", "r", "s");
        System.out.println(josephusPermutation(numerico, 3));
        System.out.println(josephusPermutation(stringhe, 4));
    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {

        int indiceAttuale = 0;
        List<T> nuoviOggetti = new ArrayList<>();
        List<T> copiaItems = new ArrayList<>(items);
        while (!copiaItems.isEmpty()) {
            indiceAttuale = (indiceAttuale + k - 1) % copiaItems.size();
            nuoviOggetti.add(copiaItems.get(indiceAttuale));
            copiaItems.remove(indiceAttuale);
        }
        return nuoviOggetti;
    }
}
