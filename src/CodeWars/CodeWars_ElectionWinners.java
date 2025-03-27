package CodeWars;

import java.util.Arrays;

public class CodeWars_ElectionWinners {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/58881b859ab1e053240000cc
        int[] votes = {1, 1, 1, 3, 3};
        int voters = 3;
        System.out.println(find(votes,voters));
    }
    static int find(final int[] votes, final int k) {
        int[]sortedVotes = Arrays.stream(votes).sorted().toArray();
        int winners = 1;
        if(k == 0){
            if(sortedVotes.length >= 2){
                if(sortedVotes[sortedVotes.length-1] == sortedVotes[sortedVotes.length-2]){
                    return 0;
                }
                else{
                    return winners;
                }
            }
        }
        int winning = sortedVotes[sortedVotes.length-1];
        for(int i = 0; i < sortedVotes.length -1; i++){
            if((sortedVotes[i] + k) > winning){
                winners++;
            }
        }
        return winners;
    }
}