package AdventOfCode2022.day7;

import java.io.*;
import java.util.*;

public class Main {
    // cd x moves in one level: it looks in the current directory for the directory named x and makes it the current directory.
    // cd .. moves out one level: it finds the directory that contains the current directory, then makes that directory the current directory.
    // cd / switches the current directory to the outermost directory, /.
    // ls means list. It prints out all of the files and directories immediately contained by the current directory:
    // 123 abc means that the current directory contains a file named abc with size 123.
    // dir xyz means that the current directory contains a directory named xyz.

    public static Directory root = new Directory("/");
    public static Directory directoryAttuale = root;
    public static long risultatoParte1 = 0;

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day7completo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null) {
            processaInput(st);
        }
        root.calcolaDimensioneDirectory();
        System.out.println("Risultato Parte 1: " + risultatoParte1);

    }

    public static void processaInput(String rigo) {
        String comando = rigo.substring(0, 4);

        // aggiungo file e directory
        if (comando.startsWith("dir ") ||Character.isDigit(comando.charAt(0))) {
            popolaDirectory(rigo);
        }

        // cambio di directory
        else if (comando.equals("$ cd")) {
            String nomeDirectory = rigo.replace("$ cd ", "").trim();
            cambiaDirectory(nomeDirectory);
        }
    }

    public static void popolaDirectory(String rigo) {

        if (rigo.startsWith("dir ")) {
            String nomeDirectory = rigo.replace("dir ", "").trim();
            Directory esistente = directoryAttuale.cercaSottocartella(nomeDirectory);
            if (esistente == null) {
                Directory nuovaDirectory = new Directory(nomeDirectory, directoryAttuale);
                directoryAttuale.aggiungiSottocartella(nuovaDirectory);
                System.out.println("Aggiunta cartella (\"" + nomeDirectory + "\")");
            }
        }
        else if(Character.isDigit(rigo.charAt(0))){
            String[] file = rigo.split(" ");
            Documento documento = new Documento(Long.parseLong(file[0]), file[1]);
            directoryAttuale.aggiungiFile(documento);
            System.out.println("Aggiunto file \"" + file[1] + "\" alla cartella \"" + directoryAttuale.getNome() + "\"");
        }
    }

    public static void cambiaDirectory(String nomeDirectory) {
        System.out.println(">>> tentativo di cambiare la directory in \"" + nomeDirectory + "\"");
        // salgo di un livello
        if (nomeDirectory.equals("..")) {
            if (directoryAttuale.getGenitore() != null) {
                System.out.println("Directory cambiata in \"" + directoryAttuale.getGenitore().getNome() + "\"");
                directoryAttuale = directoryAttuale.getGenitore();
            }
        }
        else if (!nomeDirectory.equals("/")) {
            Directory prossimaDirectory = directoryAttuale.cercaSottocartella(nomeDirectory);
            if (prossimaDirectory != null) {
                System.out.println("Directory cambiata in \"" + prossimaDirectory.getNome() + "\"");
                directoryAttuale = prossimaDirectory;
            } else {
                System.out.println("Errore: Directory \"" + nomeDirectory + "\" non trovata");
            }
        }
        else {
            System.out.println("Directory cambiata in Root");
            directoryAttuale = root;
        }
    }


}
