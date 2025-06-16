package CodeWars._5kyu.Vagoni;

public class Soluzione1 {
    public static void main(String[] args) {

        boolean[] wagons = {true, false, true, false, false};
        Train train = new Train(wagons);

        System.out.print("Before: ");
        train.printTrain();

        int count = howManyWagons(train);
        System.out.println("Number of wagons: " + count);

        System.out.print("After:  ");
        train.printTrain();
    }

    public static int howManyWagons(Train train) {

        // TODO: una strat sarebbe quella di tornare indietro tipo di 2 vagoni spegnere le luci, e poi tornare alla casella iniziale e accenderla, per poi continuare in avanti,
        //  avendo così un conto dove la fine del vagone è 0 0 e poi 1(inizio)

        for(int i = 0; i < 20; i++) {
            System.out.println(train.isLightOnInCurrentWagon());
            train.goToNextWagon();
        }
        return 0;
    }
}
