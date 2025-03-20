package CodeAbbey;
import java.util.Scanner;
public class CodeAbbey_TwoPrinters {
    public static void main(String[] args) {

//        https://www.codeabbey.com/index/task_view/two-printers
//        John and Mary founded J&M publishing house and bought two old printers to equip it.
//        Now they have their first commercial deal - to print a document consisting of N pages.
//        It appears that printers work at different speed. One produces a page in X seconds and other does it in Y seconds.
//        So now company founders are curious about minimum time they can spend on printing the whole document with two printers.
//
//        Input data contains number of test cases in the first line.
//        Then test-cases will follow, each in separate line.
//        Each testcase contains three integer values - X Y N, where N will not exceed 1,000,000,000.
//        Answer should contain minimum printing times for each of testcases, separated by spaces.
//
//        Example:
//        input data:
//        2
//        1 1 5
//        3 5 4
//        answer:
//        3 9
        Scanner scanner = new Scanner(System.in);
        int numeroStampa = scanner.nextInt();
        for(int i = 0; i < numeroStampa; i++){
            int velStampanteX = scanner.nextInt();
            int velStampanteY = scanner.nextInt();
            int numeroPagine = scanner.nextInt();
            System.out.println(stampa(velStampanteX,velStampanteY,numeroPagine) + " ");
        }

    }
    public static long stampa(int velStampanteX, int velStampanteY, int numeropagine){

        int tempoX = 0,tempoY = 0;
        long tempoTotale = 0;
        int pagineStampate = 0;


        if(velStampanteX == velStampanteY){
            return numeropagine / 2;
        }

        while(pagineStampate < numeropagine){
            if(tempoX == velStampanteX){
                tempoX = 0;
                pagineStampate++;
                System.out.println("PAGINE STAMPATE: "+pagineStampate);
                if(pagineStampate == numeropagine){
                    break;
                }
            }
            if(tempoY == velStampanteY){
                tempoY = 0;
                pagineStampate++;
                System.out.println("PAGINE STAMPATE: "+pagineStampate);
                if(pagineStampate == numeropagine){
                    break;
                }
            }
            tempoTotale++;
            tempoX++;
            tempoY++;

        }
        return tempoTotale;
    }
}
