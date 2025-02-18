package AdventOfCode2024;

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class adventOfCodeDay3 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Mary\\Desktop\\testiJava\\2024\\avventoGiorno3input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int totaleParte1 = 0, totaleParte2 = 0;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        boolean flag = true;
        for(String s : righe){
            totaleParte1 += calcolaParte1(s);
            HashMap<Integer,Boolean> mappa = calcolaParte2(s,flag);
            if (!mappa.isEmpty()) {
                Integer chiave = mappa.keySet().iterator().next();
                totaleParte2 += chiave;
                flag = mappa.get(chiave);
            }
        }
        System.out.println("Totale parte 1: " + totaleParte1);
        System.out.println("Totale parte 2: " + totaleParte2);
    }
    public static int calcolaParte1(String s){
        String regex = "mul\\(\\d+,\\d+\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        int totale = 0;
        while(matcher.find()){
            String g = matcher.group().replaceAll("[^0-9,]+", "");
            String[] numeri = g.split(",");
            totale += (Integer.parseInt(numeri[0]) * Integer.parseInt(numeri[1]));
        }
        return totale;
    }

    public static HashMap<Integer, Boolean> calcolaParte2(String riga, boolean flag) {
        String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
        StringBuilder risultato = new StringBuilder();
        Matcher matcher = Pattern.compile(regex).matcher(riga);

        while (matcher.find()) {
            if (!risultato.isEmpty()) {
                risultato.append(" ");
            }
            risultato.append(matcher.group());
        }
        String s = risultato.toString().replaceAll(" ", "");
        Pattern pattern2 = Pattern.compile(regex);
        Matcher matcher2 = pattern2.matcher(s);
        ArrayList<String> moltiplicazioni = new ArrayList<>();
        while (matcher2.find()) {
            String riscontro = matcher2.group();
            if (riscontro.startsWith("mul") && flag) {
                moltiplicazioni.add(matcher2.group());
            } else if (riscontro.equals("do()")) {
                flag = true;
            } else if (riscontro.equals("don't()")) {
                flag = false;
            }
        }
        String regMul = "[^\\d+,]";
        for (int i = 0; i < moltiplicazioni.size(); i++) {
            moltiplicazioni.set(i, moltiplicazioni.get(i).replaceAll(regMul, ""));
        }
        int totale = 0;
        for (int i = 0; i < moltiplicazioni.size(); i++) {
            String[] daConv = moltiplicazioni.get(i).split(",");
            totale += (Integer.parseInt(daConv[0]) * Integer.parseInt(daConv[1]));
        }
        HashMap<Integer,Boolean> mappa = new HashMap<>();
        mappa.put(totale,flag);
        return mappa;
    }
}

