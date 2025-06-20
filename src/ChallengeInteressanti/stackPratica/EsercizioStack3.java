package ChallengeInteressanti.stackPratica;

import java.util.Stack;

public class EsercizioStack3 {
    public static void main(String[] args) {

//        4. Rimozione dei duplicati adiacenti
//        Dati caratteri ripetuti consecutivamente, rimuovili usando una stack.
//
//        Esempio: "abbaca" → "ca"
        System.out.println(modificaStringa("abbaca") + "\tStringa originale: \"abbaca\"");
        System.out.println(modificaStringa("cciaao") + "\tStringa originale: \"cciaao\"");
        System.out.println(modificaStringa("ddoppiaa") + "\tStringa originale: \"ddoppiaa\"");
    }
    public static String modificaStringa(String s){

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
           if(!stack.isEmpty() && stack.peek() == c){ // se la stack non è vuota, e l'elemento in cima è uguale all'elemento dell'array
               char carattereRimosso = stack.pop(); // rimuoviamo il carattere con .pop() dalla stack
               System.out.println("Rimosso:" + carattereRimosso);
           }else{
               stack.push(c); // altrimenti lo pushiamo nella stack
               System.out.println("Pushato:" + c);

           }
        }
        for(char c : stack){
            sb.append(c);
        }

        return sb.toString();
    }
}
