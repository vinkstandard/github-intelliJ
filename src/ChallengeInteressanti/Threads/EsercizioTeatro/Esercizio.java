package ChallengeInteressanti.Threads.EsercizioTeatro;

import net.datafaker.Faker;

public class Esercizio extends Thread{

    /*
    Tutti i thread partono all'unisono, e cercano tutti di prenotare lo stesso posto, l'aggiunta di
    synchronized nel metodo della prenotazione fa si che il primo che arriva, fa aspettare gli altri, quando finisce passa il prossimo
    che fa la stessa cosa. In poche parole crea una coda
    */
    static Faker faker = new Faker();
    static Theatre theatre = new Theatre(new boolean[10]);

    public static void main(String[] args) {
        Esercizio thread1 = new Esercizio();
        Esercizio thread2 = new Esercizio();
        Esercizio thread3 = new Esercizio();
        Esercizio thread4 = new Esercizio();
        Esercizio thread5 = new Esercizio();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
    public void run(){
        theatre.bookSeat(1, faker.name().fullName());
    }
}

class Theatre {
    private boolean[] seats;

    public Theatre(boolean[] seats) {
        this.seats = seats;
    }

    public void bookSeat(int seatNumber, String name) {
        /* non c'è bisogno di sincronizzare la validazione
        se non ci fossero state validazioni da fare, potevamo direttamente aggiugere synchronized nella dichiarazione del metodo
        "public synchronized void bookSeat()"
        */
        if(name == null || name.isEmpty()){
            System.out.println("Nome non valido");
            return;
        }

        synchronized(this){
            if (!seats[seatNumber]) {
                seats[seatNumber] = true;
                System.out.println("Posto n." + seatNumber + " prenotato da " + name);
            } else {
                System.out.println("Il posto n." + seatNumber + " è già occupato.");
            }
        }
    }
}
