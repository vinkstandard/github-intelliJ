package CodeWars;
public class CodeWars_TakeATenMinutesWalk {
    public static boolean isValid(char[] walk) {
        int[]steps = new int[2];
        if(walk.length == 10){
            for(char c : walk){
                switch(c){
                    case 'n': steps[0] += 1; break;
                    case 's': steps[0] -= 1; break;
                    case 'w': steps[1] += 1; break;
                    case 'e': steps[1] -= 1; break;
                }
            }
            if(steps[0] == 0 && steps[1] == 0){
                return true;
            }
        }
        return false;
    }
}