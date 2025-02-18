package CodeAbbey;

import java.util.Scanner;
public class CodeAbbey_FoolsDay2014 {
    public static void main(String[] args) {
//        Today I wanted to create new task and found it is April 1 2014 - the Fool's Day when people are trying to overjoke each other.
//
//        So here is a small programming problem without the problem statement. Nevertheless you can do it! Good luck! :)
//
//        Example:
//
//        input data:
//        5
//        1 2
//        1 2 3
//        2 3 4
//        2 4 6 8 10
//        7 11 19
//
//        answer:
//        5 14 29 220 531

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < n; i++){
            int totale = 0;
            String s = scanner.nextLine();
            int[] numeri = splittaStringa(s);
            for (int k : numeri) {
                totale += (k * k);
            }
            System.out.print(totale + " ");
        }
    }
    public static int[] splittaStringa(String s){
        String[]numeriString = s.split(" ");
        int[]numeri = new int[numeriString.length];
        for(int i = 0; i < numeriString.length; i++){
            numeri[i] = Integer.parseInt(numeriString[i]);
        }
        return numeri;
    }
}
