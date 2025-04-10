package CodeWars._6kyu;

public class CodeWars_SuperMarketQueue {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/57b06f90e298a7b53d000a86/train/java
//        There is a queue for the self-checkout tills at the supermarket. Your task is write a function to calculate the total time required
//        for all the customers to check out!
//
//        input:
//
//        customers: an array of positive integers representing the queue.
//        Each integer represents a customer, and its value is the amount of time they require to check out.
//
//        n: a positive integer, the number of checkout tills.
//
//        output:
//        The function should return an integer, the total time required.
//
//        Important
//        Please look at the examples and clarifications below, to ensure you understand the task correctly :)
//
//        Examples:
//
//        queueTime([5,3,4], 1) = return 12
//        because when there is 1 till, the total time is just the sum of the times
//
//        queueTime([10,2,3,3], 2) = return 10
//        because here n=2 and the 2nd, 3rd, and 4th people in the
//        queue finish before the 1st person has finished.
//
//        queueTime([2,3,10], 2) = return 12
//
//        Clarifications:
//        There is only ONE queue serving many tills, and
//        The order of the queue NEVER changes, and
//        The front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.
//        N.B. You should assume that all the test input will be valid, as specified above.
//        P.S. The situation in this kata can be likened to the more-computer-science-related idea of a thread pool,
//        with relation to running multiple processes at the same time: https://en.wikipedia.org/wiki/Thread_pool

        System.out.println(solveSuperMarketQueue(new int[]{5, 3, 4}, 1)); // 12
        System.out.println(solveSuperMarketQueue(new int[]{10, 2, 3, 3}, 2)); // 10
        System.out.println(solveSuperMarketQueue(new int[]{2, 3, 10}, 2)); // 12
    }
    public static int solveSuperMarketQueue(int[] customers, int n) {

        if (customers.length == 0) return 0;

        if(n == 1){
            int somma = 0;
            for(int cliente : customers){
                somma += cliente;
            }
            return somma;
        }
        int[] casse = new int[n];
        for (int cliente : customers) {
            int indiceMinimo = 0;
            for (int i = 1; i < n; i++) {
                if (casse[i] < casse[indiceMinimo]) {
                    indiceMinimo = i;
                }
            }
            casse[indiceMinimo] += cliente;
        }
        int max = 0;
        for (int tempo : casse) {
            if (tempo > max) {
                max = tempo;
            }
        }
        return max;
    }
}
