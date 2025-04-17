package CodeWars._6kyu;

import java.util.ArrayList;

public class CodeWars_SumOfTwoIntegers {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5a9c35e9ba1bb5c54a0001ac
//
//        Task
//        Given Two integers a , b , find The sum of them , BUT You are not allowed to use the operators + and -
//
//        Notes
//        The numbers (a,b) may be positive , negative values or zeros .
//
//        Returning value will be an integer .
//
//        Java: the following methods are prohibited: addExact, average, collect, decrement, increment, nextAfter, nextDown, nextUp, reduce, subtractExact, sum, summing . The following classes are prohibited: BigDecimal and BigInteger .
//        Input >> Output Examples

//        1- Add (5,19) ==> return (24)
//        2- Add (-27,18) ==> return (-9)
//        3- Add (-14,-16) ==> return (-30)



    }
    public static int add(int x, int y) {
        while (y != 0) {
            int riporto = (x & y) << 1; // calcoliamo il riporto
            x = x ^ y; // somma, senz a riporto
            y = riporto; // si continuano ad aggiornare i riporti
        }
        return x;
    }
}
