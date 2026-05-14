package CodeWars._6kyu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeWars_RankingNBATeams {
    public static void main(String[] args) {

        // https://www.codewars.com/kata/5a420163b6cfd7cde5000077/train/java
        String resultSheet1 = "Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies 112,"
                + "Los Angeles Lakers 111 Minnesota Timberwolves 112,Phoenix Suns 95 Dallas Mavericks 111,Portland Trail Blazers 112 New Orleans Pelicans 94,"
                + "Sacramento Kings 104 Los Angeles Clippers 111,Houston Rockets 85 Denver Nuggets 105,Memphis Grizzlies 76 Cleveland Cavaliers 106,"
                + "Milwaukee Bucks 97 New York Knicks 122,Oklahoma City Thunder 112 San Antonio Spurs 106,Boston Celtics 112 Philadelphia 76ers 95,"
                + "Brooklyn Nets 100 Chicago Bulls 115,Detroit Pistons 92 Utah Jazz 87,Miami Heat 104 Charlotte Hornets 94,"
                + "Toronto Raptors 106 Indiana Pacers 99,Orlando Magic 87 Washington Wizards 88,Golden State Warriors 111 New Orleans Pelicans 95,"
                + "Atlanta Hawks 94 Detroit Pistons 106,Chicago Bulls 97 Cleveland Cavaliers 95,";
        List<String> tests = List.of("Boston Celtics", "Boston Celts", "", "Atlanta Hawks");

        tests.forEach(test -> System.out.println(nbaCup(resultSheet1, test)));
    }

    public static String nbaCup(String resultSheet, String toFind) {

        Pattern p3 = Pattern.compile("\\b" + Pattern.quote(toFind) + "\\b");
        Matcher m3 = p3.matcher(resultSheet);
        if(!m3.find()) return toFind + ":This team didn't play!";

        if (!resultSheet.contains(toFind)) return toFind + ":This team didn't play!";
        if (toFind.isEmpty()) return "";

        Pattern p = Pattern.compile("(?<=^|,)[^,]*\\b" + Pattern.quote(toFind) + "\\b[^,]*");

        Matcher m = p.matcher(resultSheet);
        int vittorie = 0, sconfitte = 0, parita = 0, punteggioOttenuto = 0, punteggioConcesso = 0, punti = 0;
        while (m.find()) {
            String partita = m.group();
            System.out.println(partita);
            if (partita.contains(",")) return "Error(float number):" + partita;

            List<Integer> risultati = new ArrayList<>();
            Pattern pattern2 = Pattern.compile("(?<![A-Za-z0-9])\\d+(?![A-Za-z0-9])");
            Matcher m2 = pattern2.matcher(partita);
            while(m2.find()){
                risultati.add(Integer.parseInt(m2.group()));
            }
            if (partita.startsWith(toFind)) {
                punteggioOttenuto += risultati.get(0);
                punteggioConcesso += risultati.get(1);
                if (risultati.get(0) > risultati.get(1)) {
                    vittorie++;
                    punti += 3;
                } else if (Objects.equals(risultati.get(0), risultati.get(1))) {
                    parita++;
                    punti += 1;
                } else {
                    sconfitte++;
                }
            } else {
                punteggioOttenuto += risultati.get(1);
                punteggioConcesso += risultati.get(0);
                if (risultati.get(1) > risultati.get(0)) {
                    vittorie++;
                    punti += 3;
                } else if (Objects.equals(risultati.get(1), risultati.get(0))) {
                    parita++;
                    punti += 1;
                } else {
                    sconfitte++;
                }
            }
        }
        return toFind + ":W=" + vittorie + ";D=" + parita + ";L=" + sconfitte + ";Scored=" + punteggioOttenuto + ";Conceded=" + punteggioConcesso + ";Points=" + punti;
    }
}
