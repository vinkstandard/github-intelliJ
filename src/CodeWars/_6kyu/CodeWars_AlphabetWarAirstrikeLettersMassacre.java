package CodeWars._6kyu;

import net.datafaker.idnumbers.SouthAfricanIdNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeWars_AlphabetWarAirstrikeLettersMassacre {

    public static void main(String[] args) {

//        System.out.println(alphabetWar("z*z*z*zs") + " | LEFT");
//        System.out.println(alphabetWar("sz**z**zs") + " | LEFT");
//        System.out.println(alphabetWar("wwwwww*z") + " | LEFT");
//        System.out.println(alphabetWar("zz*zzs") + " | RIGHT");
//        System.out.println(alphabetWar("z") + " | RIGHT");
//        System.out.println(alphabetWar("****") + " | NULL");
//        System.out.println(alphabetWar("z*dq*mw*pb*s") + " | NULL");
//        System.out.println(alphabetWar("zdqmwpbs") + " | NULL");
        System.out.println(alphabetWar("szz**zqjpt*") + " | NULL");
//        System.out.println(alphabetWar("aa*aa") + " | NULL");
//        System.out.println(alphabetWar("**aa**") + " | NULL");

//        The left side letters and their power:
//        w - 4
//        p - 3
//        b - 2
//        s - 1


//        The right side letters and their power:
//        m - 4
//        q - 3
//        d - 2
//        z - 1
    }

    public static String alphabetWar(String fight) {
        Map<Character, Integer> map = Map.of('w', 4, 'p', 3, 'b', 2, 's', 1, 'm', -4, 'q', -3, 'd', -2, 'z', -1);
        int score = 0;
        for(int currentIndex = 0; currentIndex < fight.length(); currentIndex++){
            char currentChar = fight.charAt(currentIndex);
            if(map.containsKey(currentChar)){
                if ((currentIndex == 0 || fight.charAt(currentIndex - 1) != '*') && (currentIndex == fight.length() - 1 || fight.charAt(currentIndex + 1) != '*')){
                    score += map.get(currentChar);
                }
            }
        }
        return score == 0 ? "Let's fight again!" : (score > 0 ? "Left" : "Right") + " side wins!";
    }
}