package CodeAbbey;
import java.util.*;

public class CodeAbbey_SweetHarvest {
    public static void main(String[] args) {

//        https://www.codeabbey.com/index/task_view/sweet-harvest
//        Here is a variation of another popular task for practicing dynamic programming approach (though of course precise algorithm is not explained by these words).
//
//        11 5 3 17 2 13 19 7
//        The Rabbit is going to cross the river. There is a straight chain of tiny isles across the flow and the animal should jump from one to another because it surely could not swim.
//
//        At each of the isles there are some candies. When the Rabbit arrives to the new isle, it collects all the candies here.
//        However, the Rabbit could not jump directly to the next isle in the chain - it just is too strong to make short jumps.
//        So, instead, it can jump over the one or two isles (i.e. from the 1st for example to 3rd or 4th but not to 2nd or 5th and further). Also the Rabbit could not jump back.
//        You can see the sample of the Rabbit's path on the drawing above. It visits 1st, 3rd, 6th and 8th isles and collects:
//
//        11 + 3 + 13 + 7 = 34
//        the amount of 34 candies. Obviously he could do better if the path is chosen more wisely.
//        Your task is to choose the best path for Rabbit over the given chain of isles - i.e. to maximize the amount of the candies collected.
//        Note that Rabbit starts from 1st isle and finishes either on the Nth or (N-1)th where N is the total number of isles (because from these two it will necessarily jump immediately to the other bank).
//
//        Input data will contain the number of test-cases in the first line.
//        Next lines contain one test-case each - i.e. one chain of isles, described by the array of numbers - amounts of candies at each isle.
//        Answer should contain the maximum possible amount of candies gathered for each test case.
//
//        Example:
//        input data:
//        2
//        11 5 3 17 2 13 19 7
//        9 7 12 7 16 3 7 17 14 13 4 6 11 6 3 3 5 4 11 3 15 12 14 2 15 19 11 12
//        answer:
//        48 157

        Scanner scanner = new Scanner(System.in);
        int numeroCasi = 1; //scanner.nextInt();
        int caramelle = 0;
        int[] mappa = {9, 7, 12, 7, 16, 3, 7, 17, 14, 13, 4, 6, 11, 6, 3, 3, 5, 4, 11, 3, 15, 12, 14, 2, 15, 19, 11, 12};
        int posizioneAttuale = 0;
        while(posizioneAttuale != mappa.length -1){
//            System.out.println("DEBUG POSIZIONE ATTUALE: " + posizioneAttuale);
            for(int i = posizioneAttuale; i < mappa.length; i++){
                // check per la prima posizione
                if(i == 0){
                    caramelle += mappa[i];
                }
//                System.out.println("DEBUG CARAMELLE ATTUALI: " + caramelle);
                // check per un salto da 3
                if(posizioneAttuale + 3 < mappa.length){
//                    System.out.println("DEBUG SALTO DA TRE");
                    if(mappa[posizioneAttuale + 3] > mappa[posizioneAttuale + 2] && posizioneAttuale + 3 != mappa.length -2){
                        caramelle += mappa[posizioneAttuale + 3];
                        posizioneAttuale += 3;
                        break;
                    }else{
                        caramelle += mappa[posizioneAttuale + 2];
                        posizioneAttuale += 2;
                        break;
                    }
                }
                // se non parte quello sopra, faremo un salto da due e basta
                if(posizioneAttuale + 2 < mappa.length){
//                    System.out.println("DEBUG SALTO DA DUE");
                    caramelle += mappa[posizioneAttuale + 2];
                    posizioneAttuale += 2;
                    break;
                }
            }
        }
        System.out.println("NUMERO FINALE CARAMELLE: " + caramelle);



    }
}
