package CodeWars._6kyu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodeWars_MazeRunner {
    public static void main(String[] args) {
        // https://www.codewars.com/kata/58663693b359c4a6560001d6/train/java

        int[][] labirinto = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 3},
                {1, 0, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 2, 1, 0, 1, 0, 1}};

        Map<String[], String> mappa = new HashMap<>();
        mappa.put(new String[]{"N", "N", "N", "N", "N", "E", "E", "E", "E", "E"}, "Finish");
        mappa.put(new String[]{"N", "N", "N", "N", "N", "E", "E", "S", "S", "E", "E", "N", "N", "E"}, "Finish");
        mappa.put(new String[]{"N", "N", "N", "N", "N", "E", "E", "E", "E", "E", "W", "W"}, "Finish");
        mappa.put(new String[]{"N", "N", "N", "W", "W"}, "Dead");
        mappa.put(new String[]{"N", "N", "N", "N", "N", "E", "E", "S", "S", "S", "S", "S", "S"}, "Dead");
        mappa.put(new String[]{"N", "E", "E", "E", "E"}, "Lost");

        for (Map.Entry<String[], String> entry : mappa.entrySet()) {
            System.out.println(walk(labirinto, entry.getKey()) + " | Previsto: " + entry.getValue());
        }
    }
//      0 = Safe place to walk
//      1 = Wall
//      2 = Start Point
//      3 = Finish Point

    public static String walk(int[][] maze, String[] directions) {
        int x = getStartingPoint(maze)[0], y = getStartingPoint(maze)[1];
        for(String direzione: directions){
            switch(direzione){
                case "N": x--; break;
                case "S": x++; break;
                case "E": y++; break;
                case "W": y--; break;
                default: System.out.println("Error");
            }
            if(x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == 1) return "Dead";
            if(maze[x][y] == 3) return "Finish";
        }
        return "Lost";
    }

    public static int[] getStartingPoint(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 2) return new int[]{i, j};
            }
        }
        return new int[]{-1,-1};
    }
}
