package CodeWars._5kyu;

import java.util.*;

public class CodeWars_FourLetterWordsMutations {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5cb5eb1f03c3ff4778402099/train/java
//        Our Setup
//        Alice and Bob work in an office. When the workload is light and the boss isn't looking, they sometimes play simple word games for fun.
//        This is one of those days!
//
//        Today's Game
//        Alice and Bob are playing what they like to call Mutations,
//        where they take turns trying to "think up" a new four-letter word (made up of four unique letters)
//        that is identical to the prior word except for only one letter. They just keep on going until their memories fail out.
//
//        Their Words
//        Alice and Bob have memories of the same size, each able to recall 10 to 2000 different four-letter words.
//        Memory words and initial game word are randomly taken from the same list of 4000 (unique, four-letter, lowercased) words,
//        any of which may appear in both memories.
//
//        The expression to "think up" a new word means that for their turn,
//        the player must submit as their response word the first valid, unused word that appears in their memory (by lowest array index),
//        as their memories are ordered from the most "memorable" words to the least.
//
//        The Rules
//        a valid response word must contain four unique letters
//        1 letter is replaced while the other 3 stay in position
//        it must be the lowest indexed valid word in that memory
//        this word cannot have already been used during the game
//        the final player to provide a valid word will win the game
//        if 1st player fails 1st turn, 2nd can win with one word
//        when both players fail the initial word, there is no winner
//
//        Your Task: To determine the winner!
//        Some Examples
//        alice = plat,rend,bear,soar,mare,pare,flap,neat,clan,pore
//
//        bob   = boar,clap,farm,lend,near,peat,pure,more,plan,soap
//
//        In the case of word = "send" and first = 0:
//        Alice responds to send with rend
//        Bob responds to rend with lend
//        Alice has no valid response to lend
//        Bob wins the game.
//
//        In the case of word = "flip" and first = 1:
//        Bob has no valid response to flip
//        Alice responds to flip with flap
//        Alice wins the game.
//
//        In the case of word = "calm" and first = 1:
//        Bob has no valid response to calm
//        Alice has no valid response to calm
//        Neither wins the game.
//
//        In the case of word = "more" and first = 1:
//        Bob has no valid response to more **
//        Alice responds to more with mare
//        Alice wins the game.
//
//        In the case of word = "maze" and first = 0:
//        Alice responds to maze with mare
//        Bob responds to mare with more **
//        Alice responds to more with pore
//        Bob responds to pore with pure
//        Alice responds to pure with pare
//        Bob has no valid response to pare
//        Alice wins the game.
//
//        ** Note that in these last two cases, Bob cannot use mere because it has two e's.
//
//        Input
//        alice ~ a(n) array/list/tuple/vector (10 <= size <= 2000) of four-letter words
//        bob ~ a(n) array/list/tuple/vector (10 <= size <= 2000) of four-letter words
//        word ~ the initial four-letter challenge word of the game
//        first ~ an integer (either 0 for Alice or 1 for Bob)
//        Output
//        0 if Alice wins
//        1 if Bob wins
//        -1 if both fail

//        caso con first = 0
//        String[] alice = new String[]{"plat", "rend", "bear", "soar", "mare", "pare", "flap", "neat", "clan", "pore"};
//        String[] bob = new String[]{"boar", "clap", "mere", "lend", "near", "peat", "pure", "more", "plan", "soap"};
//        System.out.println("CASO CON -maze = " + mutations(alice,bob,"maze",first));
//        System.out.println("CASO CON -send = " + mutations(alice,bob,"send",first));
//        int first = 0;

//        caso con first = 1
        String[]alice = new String[]{"plat", "rend", "bear", "soar", "mare", "pare", "flap", "neat", "clan", "pore"};
        String[]bob= new String[]{"boar", "clap", "mere", "lend", "near", "peat", "pure", "more", "plan", "soap"};
        int first = 1;
        System.out.println("CASO CON -maze = " + mutations(alice,bob,"flap",first));



//        assertEquals( 0, Solution.mutations(alice, bob, "maze", 0)); // Alice goes  first, Alice   wins
//        assertEquals( 1, Solution.mutations(alice, bob, "send", 0)); // Alice goes  first, Bob     wins
//        assertEquals( 1, Solution.mutations(alice, bob, "boat", 0)); // Alice fails first, Bob     wins
//        assertEquals(-1, Solution.mutations(alice, bob, "apse", 0)); // Alice fails first, neither wins
//        assertEquals( 1, Solution.mutations(alice, bob, "flap", 1)); // Bob   goes  first, Bob     wins
//        assertEquals( 0, Solution.mutations(alice, bob, "soar", 1)); // Bob   goes  first, Alice   wins
//        assertEquals( 0, Solution.mutations(alice, bob, "more", 1)); // Bob   fails first, Alice   wins
//        assertEquals(-1, Solution.mutations(alice, bob, "calm", 1)); // Bob   fails first, neither wins
    }
    public static int mutations(String[] alice, String[] bob, String word, int first) {

        ArrayList<String> paroleGiocatore1;
        ArrayList<String> paroleGiocatore2;
        if(first == 0) {
            paroleGiocatore1 = new ArrayList<>(Arrays.asList(alice));
            paroleGiocatore2 = new ArrayList<>(Arrays.asList(bob));
        }
        else{
            paroleGiocatore1 = new ArrayList<>(Arrays.asList(bob));
            paroleGiocatore2 = new ArrayList<>(Arrays.asList(alice));
        }

        ArrayList<String> paroleUsate = new ArrayList<>();
        paroleUsate.add(word);
        boolean giocatore1Good = false;
        boolean giocatore2Good = false;

        while (true) {

            String parolaDaCercare = word;
            System.out.println("--------------------INIZIO GIRO, PAROLA: " + word);
            turnoGiocatore1:
            for (int indiceLettera = 0; indiceLettera < parolaDaCercare.length(); indiceLettera++) {
                for (char c = 'a'; c < 'z'; c++) {
                    StringBuilder sb = new StringBuilder(parolaDaCercare);
                    sb.setCharAt(indiceLettera, c);
                    if (paroleGiocatore1.contains(sb.toString()) && !paroleUsate.contains(sb.toString())) {
                        if(haLettereUniche(sb.toString())){
                            paroleUsate.add(sb.toString());
                            word = sb.toString();
                            parolaDaCercare = word;
                            System.out.println("PAROLA GIOCATORE 1: " + sb);
                            giocatore1Good = true;
                            break turnoGiocatore1;
                        }
                    }else{
                        giocatore1Good = false;
                    }
                }
            }
            if(!giocatore1Good && giocatore2Good){
                if(first == 0){
                    System.out.println("USCITA 1");
                    return 1;
                }else{
                    System.out.println("USCITA 2");
                    return 0;
                }
            }

            turnoGiocatore2:
            for (int indiceLettera = 0; indiceLettera < parolaDaCercare.length(); indiceLettera++) {
                for (char c = 'a'; c < 'z'; c++) {
                    StringBuilder sb = new StringBuilder(parolaDaCercare);
                    sb.setCharAt(indiceLettera, c);
                    if (paroleGiocatore2.contains(sb.toString()) && !paroleUsate.contains(sb.toString())) {
                        if(haLettereUniche(sb.toString())){
                            paroleUsate.add(sb.toString());
                            word = sb.toString();
                            System.out.println("PAROLA GIOCATORE 2: " + sb);
                            giocatore2Good = true;
                            break turnoGiocatore2;
                        }
                    }else{
                    giocatore2Good = false;
                }
                }
            }
            System.out.println("GIOCATORE 1: "+ giocatore1Good + "\t\t\tGIOCATORE 2: " + giocatore2Good);
            if(!giocatore1Good && !giocatore2Good){
                return -1; // parità
            }
            if(giocatore1Good && !giocatore2Good){
                if(first == 0){
                    return 0;
                }else{
                    return 1;
                }
            }
        }
    }
    public static boolean haLettereUniche(String parola) {
        Set<Character> lettere = new HashSet<>();
        for (int i = 0; i < parola.length(); i++) {
            char lettera = parola.charAt(i);
            // se la lettera è già nel set, vuol dire che è duplicata
            if (!lettere.add(lettera)) {
                return false;
            }
        }
        return true;
    }
}
