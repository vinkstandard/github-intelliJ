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

        StringBuilder sb = new StringBuilder(fight);
        do {
            boolean flag = false;
            System.out.println("\nStringa inizio Ciclo: " + sb);

            for (int currentIndex = 0; currentIndex < sb.length(); currentIndex++) {
                if (sb.charAt(currentIndex) == '*') {
                    System.out.println("Trovata bomba in posizione " + currentIndex);

                    System.out.println("----------Controllo a Destra----------");
                    if (currentIndex + 1 < sb.length() && sb.charAt(currentIndex + 1) != '*') {
                        System.out.println("Esploso carattere [" + sb.charAt(currentIndex + 1) + "] in posizione " + (currentIndex + 1));
                        sb.deleteCharAt(currentIndex + 1);
                        flag = true;
                    }

                    sb.setCharAt(currentIndex, '-');

                    System.out.println("----------Controllo a Sinistra----------");
                    if (currentIndex - 1 >= 0 && sb.charAt(currentIndex - 1) != '*') {
                        System.out.println("Esploso carattere [" + sb.charAt(currentIndex - 1) + "] in posizione " + (currentIndex - 1));
                        sb.deleteCharAt(currentIndex - 1);
                        flag = true;
                    }
                }
                if (flag) break;
            }
        } while (sb.toString().contains("*"));

        int scoreRight = 0, scoreLeft = 0;
        for (char c : sb.toString().toCharArray()) {
            switch (c) {
                case 'm' -> scoreRight += 4;
                case 'q' -> scoreRight += 3;
                case 'd' -> scoreRight += 2;
                case 'z' -> scoreRight += 1;
                case 'w' -> scoreLeft += 4;
                case 'p' -> scoreLeft += 3;
                case 'b' -> scoreLeft += 2;
                case 's' -> scoreLeft += 1;
            }
        }
        System.out.println(sb + " Left: " + scoreLeft + " | Right: " + scoreRight);
        if (scoreRight > scoreLeft) return "Right side wins!";
        if (scoreRight < scoreLeft) return "Left side wins!";
        return "Let's fight again!";
    }
}