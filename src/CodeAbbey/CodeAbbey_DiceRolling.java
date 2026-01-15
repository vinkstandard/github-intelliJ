package CodeAbbey;

import java.util.*;

public class CodeAbbey_DiceRolling {
    public static void main(String[] args) {
//      https://www.codeabbey.com/index/task_view/dice-rolling

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            double d = scanner.nextDouble();
            System.out.println((int) (d *= 6) + 1);
        }
    }
}
