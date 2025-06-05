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

        righe.add("4 i n g t h k a");
        righe.add("8 v l r d c b a c g i c a s");
        righe.add("14 x h t s e t t c n p e i a u g r m c c o o v");
        righe.add("10 w e u i b r n h s v n y v u e s");
        righe.add("6 a t s e p m i m d d");
        righe.add("7 c i t e i p l r a d e");
        righe.add("4 a e q u t m p");
        righe.add("7 s r f s n i e i m l p");
        righe.add("8 i u o s n d s o n g c n l");
        righe.add("7 c u a s r o e k g a y");
        righe.add("10 l i a a a n t d u o i v a l f d");
        righe.add("6 d n s e v c r c h o");
        righe.add("7 c n r o a h h n v o s");
        System.out.println("GRANDEZZA DI RIGHE: " + righe.size());


        for (String rigo : righe) {
            System.out.print(risolvi(rigo) + " ");
        }

    }

    public static int risolvi(String rigo) {
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