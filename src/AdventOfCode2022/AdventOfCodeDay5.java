package AdventOfCode2022;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay5 {
    public static void main(String[] args) throws IOException {


        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day5completo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
//                        [B]     [L]     [S]
//                [Q] [J] [C]     [W]     [F]
//            [F] [T] [B] [D]     [P]     [P]
//            [S] [J] [Z] [T]     [B] [C] [H]
//            [L] [H] [H] [Z] [G] [Z] [G] [R]
//        [R] [H] [D] [R] [F] [C] [V] [Q] [T]
//        [C] [J] [M] [G] [P] [H] [N] [J] [D]
//        [H] [B] [R] [S] [R] [T] [S] [R] [L]
//         1   2   3   4   5   6   7   8   9
//        dall'input data noto che possiamo estrarre le posizioni precise(possibili) di ogni lettera. partono da 1 a +4, quindi 1-5-9
//         1   5   9   13  17  21  25  29  33


        List<String> containers = new ArrayList<>();
        List<String> comandi = new ArrayList<>();
        // separiamo i container dai comandi
        boolean isComandi = false;
        for (String s : righe) {
            if (s.startsWith(" 1")) {
                isComandi = true;
                continue;
            }
            if (!isComandi) containers.add(s);
            if (isComandi && !s.isEmpty()) comandi.add(s);
        }

        int[] posizioniPossibli = new int[]{1, 5, 9, 13, 17, 21, 25, 29, 33};
        List<Stack<Character>> listaStack = new ArrayList<>();
        // aggiungo tanti 3 stack per il testing, e 9 per l'esercizio
        for (int i = 0; i < 9; i++) {
            listaStack.add(new Stack<>());
        }

        //  scorriamo l'array all'indietro, in modo da buildare le stack, il primo a entrare è l'ultimo a uscire
        for (int i = containers.size() - 1; i >= 0; i--) {
            String rigo = containers.get(i);
            for (int p = 0; p < posizioniPossibli.length; p++) {
                int posizione = posizioniPossibli[p];
                if (posizione < rigo.length() && Character.isAlphabetic(rigo.charAt(posizione))) {
                    char carattere = rigo.charAt(posizione);
                    listaStack.get(p).push(carattere);
                }
            }
        }
        System.out.println(comandi + "\n\n---------------------\n\n" + listaStack);


        List<Stack<Character>> listaParte1 = copiaListaStack(listaStack); // tocca usare un metodo di copiatura

        System.out.println("Risultato parte 1: " + risolviParte1(listaParte1, comandi));
        System.out.println("Risultato parte 2: " + risolviParte2(listaStack, comandi));
    }

    public static String risolviParte1(List<Stack<Character>> listaStack, List<String> comandi) {
        // puliamo i comandi

        for (int i = 0; i < comandi.size(); i++) {
            String comando = comandi.get(i);
            String[] comandiRiga = comando.replaceAll("[A-Za-z]", "").trim().replaceAll(" {2}", "-").split("-");
            int quantitaDaSpostare = Integer.parseInt(comandiRiga[0]), posizioneAttuale = Integer.parseInt(comandiRiga[1]), posizioneArrivo = Integer.parseInt(comandiRiga[2]);

            // poppiamo la stack e conserviamo in un array
            List<Character> arrayTemp = new ArrayList<>();
            for (int j = 0; j < quantitaDaSpostare; j++) {
                arrayTemp.add(listaStack.get(posizioneAttuale - 1).pop());
            }
            // non serve scorrere l'array all'indietro perché le casse vengono mosse una alla volta
            for (char c : arrayTemp) {
                listaStack.get(posizioneArrivo - 1).push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Stack<Character> stack : listaStack) {
            sb.append(stack.peek());
        }
        return sb.toString();
    }

    public static String risolviParte2(List<Stack<Character>> listaStack, List<String> comandi) {
        // puliamo i comandi

        for (int i = 0; i < comandi.size(); i++) {
            String comando = comandi.get(i);
            String[] comandiRiga = comando.replaceAll("[A-Za-z]", "").trim().replaceAll(" {2}", "-").split("-");
            int quantitaDaSpostare = Integer.parseInt(comandiRiga[0]), posizioneAttuale = Integer.parseInt(comandiRiga[1]), posizioneArrivo = Integer.parseInt(comandiRiga[2]);

            // poppiamo la stack e conserviamo in un array
            List<Character> arrayTemp = new ArrayList<>();
            for (int j = 0; j < quantitaDaSpostare; j++) {
                arrayTemp.add(listaStack.get(posizioneAttuale - 1).pop());
            }
            // l'unica differenza qui rispetto alla parte 1 è che l'operatore della gru sposta piu casse alla volta, quindi tocca scorrere l'array all'indietro
            for (int arr = arrayTemp.size() - 1; arr >= 0; arr--) {
                listaStack.get(posizioneArrivo - 1).push(arrayTemp.get(arr));

            }
        }
        StringBuilder sb = new StringBuilder();
        for (Stack<Character> stack : listaStack) {
            sb.append(stack.peek());
        }
        return sb.toString();
    }

    public static List<Stack<Character>> copiaListaStack(List<Stack<Character>> original) {
        List<Stack<Character>> listaCopiata = new ArrayList<>(original.size());
        for (Stack<Character> stackOriginale : original) {
            Stack<Character> nuovoStack = new Stack<>();
            nuovoStack.addAll(stackOriginale);
            listaCopiata.add(nuovoStack);
        }
        return listaCopiata;
    }

}
