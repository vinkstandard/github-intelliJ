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
        // 1 giorno = 86400 secondi

        System.out.println(makeReadable(47260800));
        System.out.println(giorniInSecondi(547));
    }
    public static String makeReadable(int seconds) {

        int restoSecondi = seconds % 60;
        int minuti = seconds / 60;
        int ore = minuti / 60;
        minuti = minuti % 60;
//        int giorni = ore / 24;   4 fun :)
        ore = ore % 24;
        String secondiStringa = String.valueOf(restoSecondi), minutiStringa = String.valueOf(minuti), oreStringa = String.valueOf(ore);

        // eventuali aggiunte di zeri
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
        return oreStringa + ":" + minutiStringa + ":" + secondiStringa; // giorni + ":" +
    }
    public static String giorniInSecondi(int giorni){
        int ore = giorni * 24;
        int minuti = ore * 60;
        int secondi = minuti * 60;
        return Integer.toString(secondi);
    }
}
