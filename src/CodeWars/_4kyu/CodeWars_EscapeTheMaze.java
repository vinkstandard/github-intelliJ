package CodeWars._4kyu;

import java.util.ArrayList;
import java.util.List;

public class CodeWars_EscapeTheMaze {
    public static void main(String[] args) {

        // https://www.codewars.com/kata/5877027d885d4f6144000404/train/java

        List<char[][]> labirinti = new ArrayList<>();
        labirinti.add(new char[][] {
                "# #".toCharArray(),
                " > ".toCharArray(),
                "# #".toCharArray()
        });
        labirinti.add(new char[][] {
                "###########".toCharArray(),
                "#>        #".toCharArray(),
                "######### #".toCharArray()
        });
        labirinti.add(new char[][] {
                "# #########".toCharArray(),
                "#        >#".toCharArray(),
                "###########".toCharArray()
        });

    }
    public static List<Character> escape(char[][] maze) {

        return null;
    }
}
