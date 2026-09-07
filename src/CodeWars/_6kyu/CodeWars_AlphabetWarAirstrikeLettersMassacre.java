package CodeWars._6kyu;

import net.datafaker.idnumbers.SouthAfricanIdNumber;

import java.util.List;

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
        List<Character> powerLetters = List.of('w', 'p', 'b', 's', 'm', 'q', 'd', 'z');
        int rightScore = 0, leftScore = 0;
        for(int currentIndex = 0; currentIndex < fight.length(); currentIndex++){
            char currentChar = fight.charAt(currentIndex);

            if(powerLetters.contains(currentChar)){
                if ((currentIndex == 0 || fight.charAt(currentIndex - 1) != '*') && (currentIndex == fight.length() - 1 || fight.charAt(currentIndex + 1) != '*')){
                    switch (currentChar) {
                        case 'm' -> rightScore += 4;
                        case 'q' -> rightScore += 3;
                        case 'd' -> rightScore += 2;
                        case 'z' -> rightScore += 1;
                        case 'w' -> leftScore += 4;
                        case 'p' -> leftScore += 3;
                        case 'b' -> leftScore += 2;
                        case 's' -> leftScore += 1;
                    }
                }
            }
        }
        if (rightScore > leftScore) return "Right side wins!";
        if (rightScore < leftScore) return "Left side wins!";
        return "Let's fight again!";
    }
}