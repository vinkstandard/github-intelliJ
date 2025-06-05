package CodeAbbey;

import java.io.*;
import java.util.*;

public class CodeAbbey_FourPicsOneWord {
    public static List<String> dizionario = new ArrayList<>();

    public static void main(String[] args) throws IOException {

//        https://www.codeabbey.com/index/task_view/four-pics-one-word
//        Here is the problem suggested by Guy Gervais. I dare to cite his letter:
//
//        I got the idea from watching my wife play one of those "4 images, 1 word" games on her tablet.
//        Often, she'll get stuck and ask me for help; and then I get stuck too. :-)
//        To help my wife in her games, I made an app that will accept the candidate letters,
//        the word length and use a list of words to give all the possibilities.
//        Here is the link.
//
//        So the idea is basically to give a word list to the user (everyone uses the same word list)
//        with a number of random letters and a desired word length; the goal is to find all the possible words in the list.
//        The results could be to count the words...
//
//        My wife also plays this game sometimes. I dare to retell the rules - user is given 4 images and a handful of letters.
//        The goal is to guess the word described by these images which could be built of these letters.
//
//        So you see, you are to write the program which searches through the dictionary for suitable words.
//        As a matter of fact it is the advanced version of Anagrams because it is not necessary to use all letters.
//
//        Download dictionary file by this link
//
//        Input data contain the number of testcases in the first line.
//        Each of the following lines contains the required length of the word and a set of letters.
//        Answer should contain the amount of words from dictionary satisfying each case.
//
//        Example:
//
//        input data:
//        2
//        3 t c a z
//        3 t c a f
//
//        answer:
//        2 4
//        First case allows words cat and act while second adds fat and aft to them.


        File file = new File("C:\\Users\\Mary\\Desktop\\dizionario.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            dizionario.add(st);
        }
        System.out.println(">> Dizionario caricato.");
        ArrayList<String> righe = new ArrayList<>();

//        righe.add("3 t c a z");
//        righe.add("3 t c a f");
        righe.add("8 j e o j e x p x v v r d t");
        righe.add("8 o f q h s b l d t o e b k");
        righe.add("5 d u w e p r i u");
        righe.add("10 u n l a g o c q p i n r v w i n");
        righe.add("16 e s i s c y i g n o n a r r h s i f e o u t p r e");
        righe.add("6 h d u t g h s m q e");
        righe.add("12 y b m d n e e k n i o i u d s n t l e");
        righe.add("7 g f a h i n c f z v c");
        righe.add("4 l d g l d a n");
        righe.add("9 d l h u p a s h k u i o c t");
        righe.add("10 d e f m b d l o d w e e a i j i");
        righe.add("9 i g t o n x e b z u t g s r");
        righe.add("9 s d d d o r g p z c i a e e");
        righe.add("7 g t l h q i k v s a n");
        righe.add("9 d a n h m t y i s l d l h e");
        System.out.println("GRANDEZZA DI RIGHE: " + righe.size());



        for(String rigo : righe){
            System.out.print(risolvi(rigo) + " ");
        }
        // occhio con le parole che possono avere doppie, non so se contano, come well (con w e l) se conta per una parola da 4, bho?
//
    }
    public static int risolvi(String rigo){
        String[] parti = rigo.split(" ");
        int numero = Integer.parseInt(parti[0]);

        HashMap<Character, Integer> lettereDaCercare = new HashMap<>();
        for (int i = 1; i < parti.length; i++) {
            char carattere = parti[i].charAt(0);
            lettereDaCercare.put(carattere, lettereDaCercare.getOrDefault(carattere, 0) + 1);
        }

        List<String> paroleTrovate = new ArrayList<>();
        for (String parola : dizionario) {
            if (parola.length() != numero)
                continue;

            HashMap<Character, Integer> lettereParola = new HashMap<>();
            for (char carattere : parola.toCharArray()) {
                lettereParola.put(carattere, lettereParola.getOrDefault(carattere, 0) + 1);
            }

            boolean valida = true;
            for (Map.Entry<Character, Integer> entry : lettereParola.entrySet()) {
                if (lettereDaCercare.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    valida = false;
                    break;
                }
            }

            if (valida) {
                paroleTrovate.add(parola);
            }
        }
        return paroleTrovate.size();
    }

}
