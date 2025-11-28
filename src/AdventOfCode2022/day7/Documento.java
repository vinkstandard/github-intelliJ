package AdventOfCode2022.day7;

public class Documento {
    private String nome;
    private long dimensione;

    public Documento(long dimensione, String nome) {
        this.dimensione = dimensione;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getDimensione() {
        return dimensione;
    }

    public void setDimensione(long dimensione) {
        this.dimensione = dimensione;
    }
}
