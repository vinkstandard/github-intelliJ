package ChallengeInteressanti.stackPratica;

import java.util.Stack;

public class EsercizioStack2 {
    public static void main(String[] args) {

//        3. Inversione di una stringa
//        Usa una stack per invertire una stringa.
//
//        Esempio: "hello" → "olleh"
        System.out.println(invertiStringa("hello"));

    }
    public static String invertiStringa(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            stack.push(c);
        }
        int numeroElementiStack = stack.size();
        for(int i = 0; i < numeroElementiStack; i++){
            sb.append(stack.pop());
        }
        return sb.toString();

    }
}
