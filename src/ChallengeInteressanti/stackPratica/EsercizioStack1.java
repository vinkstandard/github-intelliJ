package ChallengeInteressanti.stackPratica;

import java.util.Stack;

public class EsercizioStack1 {
    public static void main(String[] args) {
//        1. Parentesi bilanciate
//        Verifica se una stringa contenente (, ), {}, [] è bilanciata.
//
//        Esempio: "({[]})" → true, "([)]" → false

        String s = "({[]})";
        System.out.println(controllaParentesi("({[]})"));     // true
//        System.out.println(controllaParentesi("([)]"));       // false
//        System.out.println(controllaParentesi("((()))"));     // true
//        System.out.println(controllaParentesi("{[()]}"));     // true
//        System.out.println(controllaParentesi("((("));        // false
//        System.out.println(controllaParentesi(""));           // true

    }
    public static boolean controllaParentesi(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // se è una parentesi aperta, la metto nello stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) { // se la parentesi è chiusa, ma la stack è vuota, allora = false
                    return false;
                }

                char top = stack.pop(); // tiriamo fuori il primo elemento dalla stack
                System.out.println("POPPATO: " + top + "\tVALORE DI C: " + c);

                if (c == ')' && top != '('){
                    return false;
                }
                if (c == '}' && top != '{'){
                    return false;
                }
                if (c == ']' && top != '['){
                    return false;
                }
            }
        }
        // Alla fine, la stack deve essere vuota
        return stack.isEmpty();
    }
}
