package CodeWars._6kyu;

import java.util.Map;

public class CodeWars_WhatCenturyIsIt {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/52fb87703c1351ebd200081f
//        "1999" --> "20th"
//        "2011" --> "21st"
//        "2154" --> "22nd"
//        "2259" --> "23rd"
//        "1124" --> "12th"
//        "2000" --> "20th"
        Map<Integer, String> input = Map.of(1999, "20th", 2011, "21st", 2154, "22nd", 2259, "23rd", 1124, "12th", 2000, "20th", 9954, "100th");
        for(Map.Entry<Integer,String> mappa : input.entrySet()){
            System.out.println("Anno: " + mappa.getKey() + " | Risultato: (" + whatCentury(mappa.getKey()) + ") | Previsto: " + mappa.getValue());
        }
    }
    public static String whatCentury(int year) {

        String secolo = String.valueOf(year + 99).substring(0, 2);
        if(year > 8999) secolo += 0;
        if(secolo.equals("11") || secolo.equals("12") || secolo.equals("13")) return secolo + "th";
        switch(secolo.charAt(1)){
            case '1' -> { return secolo + "st"; }
            case '2' -> { return secolo + "nd"; }
            case '3' -> { return secolo + "rd"; }
            default -> { return secolo + "th"; }
        }
    }
}
