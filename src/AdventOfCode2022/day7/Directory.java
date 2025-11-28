package AdventOfCode2022.day7;

import java.util.*;

public class Directory {

    private String nome;
    private List<Directory> sottocartelle;
    private Directory genitore;
    private List<Documento> file;

    public Directory(String nome) {
        this.nome = nome;
        this.sottocartelle = new ArrayList<>();
        this.file = new ArrayList<>();
        this.genitore = null; // root non ha un genitore
    }

    public Directory(String nome, Directory genitore) {
        this.nome = nome;
        this.sottocartelle = new ArrayList<>();
        this.file = new ArrayList<>();
        this.genitore = genitore;
    }

    public void aggiungiSottocartella(Directory dir) {
        this.sottocartelle.add(dir);
    }

    public void aggiungiFile(Documento doc) {
        this.file.add(doc);
    }

    public Directory cercaSottocartella(String nome) {
        for (Directory sottocartella : this.sottocartelle) {
            if (sottocartella.getNome().equals(nome)) {
                return sottocartella;
            }
        }
        return null;
    }

    public long calcolaDimensioneDirectory() {
        long totale = 0;
        // calcoliamo la dimensione dei file nella cartella attuale
        for (Documento file : this.file) {
            totale += file.getDimensione();
        }
        // calcoliamo la dimensione dei file nelle sottocartelle usando la ricorsione
        for (Directory sottocartella : this.sottocartelle) {
            totale += sottocartella.calcolaDimensioneDirectory();
        }
        if(totale <= 100000){
            Main.risultatoParte1 += totale;
        }
        return totale; // continuiamo a restituire il totale per la ricorsione
    }

    public Directory getGenitore() {
        return genitore;
    }

    public void setGenitore(Directory genitore) {
        this.genitore = genitore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Directory> getSottocartelle() {
        return sottocartelle;
    }

    public List<Documento> getFile() {
        return file;
    }

    public void setFile(List<Documento> file) {
        this.file = file;
    }
}
