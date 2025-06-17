package CodeWars._5kyu.Vagoni;

public class Soluzione1 {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5df7a5ddc6ba51002822cf00/train/java
//        You are in a Train that is permanently moving in a circle. The Train is looped:
//        The head is connected with the tail and you can go from one to another directly.
//
//        Every wagon has a light, you can switch it on and off if you wish.
//        Count the number of wagons!
//        You can move between wagons as you wish.
//
//        Constraints:
//        After you count the wagons, the lights in the train should be in the initial state they were in.
//        But at the end you don't need to be in the same wagon where you started.
//
//        Use the implemented Train methods:
//
//        public boolean isLightOnInCurrentWagon()
//
//        public void switchLight()
//
//        public void goToNextWagon()
//
//        public void goToPreviousWagon()
//        Train notation "1 : 0 : 0" means that you have a train with three wagons. The light is on in the first wagon and off in the other two.


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

        // TODO: una strategia sarebbe quella di tornare indietro tipo di 2 vagoni spegnere le luci, e poi tornare alla casella iniziale e accenderla, per poi continuare in avanti,
        //  avendo così un conto dove la fine del vagone è 0 0 e poi 1(inizio)
        //  per ora provo con spegnerle tutte e poi a riaprirle
        //  .
        //  un'altra sarebbe quella di accenderle tutte, e contare gli spostamenti e creare una lista delle luci default, quando però trovi 2 luci già accese di seguito, allora continui a controllare i vagoni avanti,
        //  (senza toccare le luci) se sono tutti accesi allora vuol dire che le hai accese tutte e sei nel loop

        // 1 : 1 : 1 : 0 : 1 : 1 : 0 : 1

        //  questa strat funziona, ma non conta questo:
        //        Constraints:
        //        After you count the wagons, the lights in the train should be in the initial state they were in.
        //        But at the end you don't need to be in the same wagon where you started.

        for(int i = 0; i < 20; i++) {
            if(train.isLightOnInCurrentWagon()){
                System.out.println("spengo la luce");
                train.switchLight();
                train.goToNextWagon();
                continue;
            }
            train.goToNextWagon();
        }
        int conto = 1;
        train.switchLight(); // accendiamo la luce attuale, e quindi conto parte con 1
        train.goToNextWagon();
        for(int i = 0; i < 20; i++) {
            if(!train.isLightOnInCurrentWagon()){
                train.goToNextWagon();
                conto++;
            }else{
                System.out.println("BREAKING");
                break;
            }
        }
        return conto;
    }
}
