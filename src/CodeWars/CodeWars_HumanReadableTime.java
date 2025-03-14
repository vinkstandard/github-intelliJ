package CodeWars;

public class CodeWars_HumanReadableTime {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/52685f7382004e774f0001f7
//        Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)
//        HH = hours, padded to 2 digits, range: 00 - 99
//        MM = minutes, padded to 2 digits, range: 00 - 59
//        SS = seconds, padded to 2 digits, range: 00 - 59
//        makeReadable(86399)", "23:59:59",;
//        ("makeReadable(359999)", "99:59:59"

        System.out.println(makeReadable(120));
    }
    public static String makeReadable(int seconds) {

        int restoSecondi = seconds % 60;
        int minuti = seconds / 60;
        int giorni = minuti / 60;
        minuti = minuti % 60;

        String secondiStringa = String.valueOf(restoSecondi), minutiStringa = String.valueOf(minuti), oreStringa = String.valueOf(giorni);

        // conversioni
        if(secondiStringa.length() == 1){
            int num = Integer.parseInt(secondiStringa);
            secondiStringa = "0" + num;
        }
        if(minutiStringa.length() == 1){
            int num = Integer.parseInt(minutiStringa);
            minutiStringa = "0" + num;
        }
        if(oreStringa.length() == 1){
            int num = Integer.parseInt(oreStringa);
            oreStringa = "0" + num;
        }
        return oreStringa + ":" + minutiStringa + ":" + secondiStringa;
    }
}
