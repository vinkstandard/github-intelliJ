package LeetCode;

import java.util.*;

public class Leet_GroupAnagrams {
    public static void main(String[] args) {
//        https://leetcode.com/problems/group-anagrams/description/

        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})
                + " Expected --> " + List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea")));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> mappa = new HashMap<>();
        for (String s : strs) {
            if(!mappa.containsKey(generaChiave(s))){
                List<String> nuovaLista = new ArrayList<>();
                nuovaLista.add(s);
                mappa.put(generaChiave(s), nuovaLista);
            } else {
                mappa.get(generaChiave(s)).add(s);
            }
        }
        return new ArrayList<>(mappa.values());
    }



    public static String generaChiave(String s) {
        char[] sort = s.toCharArray();
        Arrays.sort(sort);
        return new String(sort);
    }
}
