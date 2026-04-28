package CodeWars._6kyu;

import java.util.*;

public class CodeWars_80sKidsShesASmallWonder {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/56743fd3a12043ffbb000049/train/java

        Robot robot = new Robot();
        List<String> paroleTest = List.of("hello", "world", "goodbye", "thank", "thank");
        paroleTest.forEach(parola -> System.out.println(robot.learnWord(parola)));
    }
}

class Robot {
    private final Set<String> listaParole = new HashSet<>(
            Arrays.asList("thank", "you", "for", "teaching", "me", "i", "already", "know", "the", "word", "do", "not", "understand", "input"));
    public Robot() {}
    public String learnWord(String parola) {
        if (parola == null || parola.isEmpty() || !parola.matches("[a-zA-Z]+")) {
            return "I do not understand the input";
        }
        if (listaParole.contains(parola.toLowerCase())) {
            return "I already know the word " + parola;
        } else {
            listaParole.add(parola.toLowerCase());
            return "Thank you for teaching me " + parola;
        }
    }
}
