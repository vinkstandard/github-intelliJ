package CodeWars._4kyu;

import java.util.*;

public class CodeWars_CanYouReachTheExit {
    public static void main(String[] args) {

        // https://www.codewars.com/kata/5765870e190b1472ec0022a2/train/java

        Map<String, Boolean> map = new HashMap<>() {{
            put("""
                    .W.
                    .W.
                    ...""", true);
            put("""
                    .W.
                    .W.
                    W..""", false);
            put("""
                    ......
                    ......
                    ......
                    ......
                    ......
                    ......""", true);
            put("""
                    ......
                    ......
                    ......
                    ......
                    .....W
                    ....W.""", false);

        }};
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            System.out.println(pathFinder(entry.getKey()) + " | Expected " + entry.getValue());
        }
    }

    static boolean pathFinder(String maze) {
        int len = maze.split("\n").length;
        char[][] newMaze = new char[len][len];
        boolean[][] visitedPos = new boolean[len][len];
        int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < len; i++) {
            newMaze[i] = maze.split("\n")[i].toCharArray();
        }
        Queue<Node> queue = new LinkedList<>();
        Node startingPos = new Node(0, 0);
        queue.add(startingPos);
        visitedPos[0][0] = true;
        while(!queue.isEmpty()){
            Node currentPos = queue.poll();
            int x = currentPos.x, y = currentPos.y;
            if(x == len - 1 && y == len -1) return true;
            for(int[] move : moves){
                int newX = x + move[0], newY = y + move[1];
                if(newX < 0 || newX == len || newY < 0 || newY == len) continue; // out of bounds
                if(newMaze[newX][newY] == '.' && !visitedPos[newX][newY]){
                    Node newPos = new Node(newX, newY);
                    queue.add(newPos);
                    visitedPos[newX][newY] = true;
                }
            }
        }
        return false;
    }
    private record Node(int x, int y) {}
}