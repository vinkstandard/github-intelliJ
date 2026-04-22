package CodeWars._7kyu;

import java.util.*;

public class CodeWars_ListFiltering {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/53dbd5315a3c69eed20002dd/train/java

        System.out.println(filterList(List.of(1, 2, "a", "b")));
        System.out.println(filterList(List.of(1, "a", "b", 0, 15)));
        System.out.println(filterList(List.of(1, 2, "aasf", "1", "123", 123)));
    }

    public static List<Object> filterList(final List<Object> list) {
        List<Object> lista = new ArrayList<>(list);
        list.forEach(elemento ->{
            if(elemento instanceof String) lista.remove(elemento);
        });
        return lista;
    }
}
