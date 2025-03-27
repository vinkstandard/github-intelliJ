package CodeWars._6kyu;

import java.util.Arrays;

public class CodeWars_MultiplicationTable {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/534d2f5b5371ecf8d2000a08
//        Your task, is to create N×N multiplication table, of size provided in parameter.
//        For example, when given size is 3:
//
//        1 2 3
//        2 4 6
//        3 6 9

//        For the given example, the return value should be:
//        [[1,2,3],[2,4,6],[3,6,9]]
        int n = 3;
        System.out.println(Arrays.deepToString(multiplicationTable(n)));
    }
    public static int [][] multiplicationTable(int n){

        int[][]tavolo = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0){
                    tavolo[i][j] = j+1;
                }
                else{
                    tavolo[i][j] = (j+1) * (i+1);
                }
            }
        }
        return tavolo;
    }
}
