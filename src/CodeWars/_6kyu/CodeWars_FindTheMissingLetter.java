package CodeWars._6kyu;
import java.util.*;

public class CodeWars_FindTheMissingLetter {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5839edaa6754d6fec10000a2
//        ['a','b','c','d','f'] -> 'e'
//        ['O','Q','R','S'] -> 'P'

        char[]array = {'O','Q','R','S'};
        System.out.println(findMissingLetter(array));
    }
    public static char findMissingLetter(char[] array){

        ArrayList<Character> alfabeto = new ArrayList<>();
        for(char c = 'a'; c <= 'z'; c++){
            alfabeto.add(c);
        }
        int indiceInizio = alfabeto.indexOf(Character.toLowerCase(array[0]));
        int contoLettera = 0;
        for(int i = indiceInizio; i < alfabeto.size(); i++){
            if(Character.toLowerCase(array[contoLettera]) != alfabeto.get(i)){
                if(Character.isLowerCase(array[0])) {
                    return alfabeto.get(i);
                }
                else{
                    return Character.toUpperCase(alfabeto.get(i));
                }
            }
            contoLettera++;
        }
        return ' ';
    }
}
