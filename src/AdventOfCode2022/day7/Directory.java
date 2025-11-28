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

    public Directory(String nome, Directory genitore){
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
