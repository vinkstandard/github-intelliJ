package CodeWars;

import java.util.HashMap;
import java.util.Objects;

public class CodeWars_StringMix {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5629db57620258aa9d000014
//        The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum,
//        if this maximum is strictly greater than 1;
//        these letters will be prefixed by the number of the string where they appear with their maximum value and :.
//        If the maximum is in s1 as well as in s2 the prefix is =:.

//        s1 = "my&friend&Paul has heavy hats! &"
//        s2 = "my friend John has many many friends &"
//        mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
//
//        s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
//        s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
//        mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
//
//        s1="Are the kids at home? aaaaa fffff"
//        s2="Yes they are here! aaaaa fffff"
//        mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"

        String s1 = "my&friend&Paul has heavy hats! &";
        String s2 = "my friend John has many many friends &";
        System.out.println(mix(s1,s2));
    }
    public static String mix(String s1, String s2) {
        HashMap<Character,Integer> conto1 = new HashMap<>();
        HashMap<Character,Integer> conto2 = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++){
            conto1.put(c,0);
            conto2.put(c,0);
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        // inserisco i valori nelle rispettive mappe
        for(char c : s1Array){
            if(conto1.containsKey(c)){
                conto1.put(c,conto1.get(c) + 1);
            }
        }
        for(char c : s2Array){
            if(conto2.containsKey(c)){
                conto2.put(c,conto2.get(c) + 1);
            }
        }
        System.out.println("\n"+conto1);
        System.out.println(conto2);



        StringBuilder ret = new StringBuilder();
        for(char c = 'a'; c <= 'z'; c++){
            StringBuilder sb = new StringBuilder();

            // se nessuno dei due ce l'ha
            if(conto1.get(c) == 0 && conto2.get(c) == 0){
                continue;
            }

            // se la lettera compare lo stesso numero di volte in entrambe le stringhe
            else if(Objects.equals(conto1.get(c), conto2.get(c))){
                sb.append("=:").append(c).append(conto1.get(c));
                String ripetizioneAggiunta = String.valueOf(c);
                sb.append(ripetizioneAggiunta.repeat(Integer.parseInt(String.valueOf(sb.charAt(sb.length()-1)))));
                sb.delete(2,4).append("/");
                ret.append(sb);
                continue;
            }

            // stringa uno
            if(conto1.get(c) > conto2.get(c)){
                // non ci interessa se è solo 1
                if(conto1.get(c) == 1){
                    continue;
                }
                sb.append("1:").append(c).append(conto1.get(c)); // appendiamo 1: poi il carattere, e un numero (quante volte dovremo aggiungere il carattere)
                String ripetizioneAggiunta = String.valueOf(c);
                sb.append(ripetizioneAggiunta.repeat(Integer.parseInt(String.valueOf(sb.charAt(sb.length()-1))))); // aggiungiamo le ripetizioni
                sb.delete(2,4).append("/"); // rimuoviamo il carattere e il numero aggiunti all'inizio e aggiungiamo lo slash per i caratteri successivi
                ret.append(sb);

            }
            // stringa due, praticamente specchiato quello che c'è scritto sopra.
            else{
                if(conto2.get(c) == 1){
                    continue;
                }
                sb.append("2:").append(c).append(conto2.get(c));
                String ripetizioneAggiunta = String.valueOf(c);
                sb.append(ripetizioneAggiunta.repeat(Integer.parseInt(String.valueOf(sb.charAt(sb.length()-1)))));
                sb.delete(2,4).append("/");
                ret.append(sb);
            }


        }
        System.out.println(ret);
        System.out.println("2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss");







        return null;
    }

}
