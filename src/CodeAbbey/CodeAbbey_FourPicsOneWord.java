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
        ArrayList<String> righe = new ArrayList<>();

        righe.add("3 t c a z");
        righe.add("3 t c a f");
//        righe.add("10 e b k i l e q g g e a s i g n l");
//        righe.add("5 j c u l p s l d");
//        righe.add("5 z b r r m l h y");
//        righe.add("10 n d f n m e i t s y q e r a t r");
//        righe.add("5 e w p o s j s p");
//        righe.add("7 u e o n x g p t s t z");
//        righe.add("4 q x g e s g u");
//        righe.add("6 r g t o d s n e h x");
//        righe.add("9 x d l e l q s c f i u h c e");
//        righe.add("9 b f l u n b l c t a a c h a");
//        righe.add("11 n i w l n i t j r x e y p t s e s");
//        righe.add("6 y u p r n r a z e d");
//        righe.add("8 n i x m r o l e c h u k g");



        for(String rigo : righe){
            System.out.print(risolvi(rigo) + " ");
        }
//
    }
    public static int risolvi(String rigo){

        int numero = Integer.parseInt(rigo.replaceAll("[a-zA-Z ]", ""));
        System.out.println(numero);


        return 0;

    }
}
