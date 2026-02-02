package CodeWars._5kyu;
import java.util.*;

public class CodeWars_StringIncrementer {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/54a91a4883a7de5d7800009c/train/java
        List<String> lista = List.of("foo", "foobar23", "foo0043", "foo9", "foo099");
        for(String elem : lista){
            System.out.println(incrementString(elem));
        }

    }
    public static String incrementString(String str) {
        if (str.isEmpty()) return "1";
        if(!Character.isDigit(str.charAt(str.length() - 1))) return str + "1";



        return "";
    }
}
