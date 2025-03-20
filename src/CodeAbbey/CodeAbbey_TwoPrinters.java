package CodeAbbey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class CodeAbbey_TwoPrinters {
    public static void main(String[] args) throws IOException {

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
        File file = new File("C:\\Users\\Mary\\Desktop\\readthis.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<Integer> totali = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            if (!st.isEmpty()) {
                String[]splitted = st.split(" ");
                int velStampanteX = Integer.parseInt(splitted[0]);
                int velStampanteY = Integer.parseInt(splitted[1]);
                int numeroPagine = Integer.parseInt(splitted[2]);
                totali.add(stampa(velStampanteX,velStampanteY,numeroPagine));
            }
        }
        for(int i : totali){
            System.out.print(i + " ");
        }
    }
    public static int stampa(int velStampanteX, int velStampanteY, int numeroPagine){

        int tempo = 0;
        int pagineStampate = 0;
        while (pagineStampate < numeroPagine) {
            tempo++; // avanti di un secondo

            // se la stampante x ha terminato il suo ciclo stampiamo una pagina
            if (tempo % velStampanteX == 0) {
                pagineStampate++;
            }
            // se la stampante y ha terminato il suo ciclo stampiamo una pagina
            if (tempo % velStampanteY == 0) {
                pagineStampate++;
            }
        }
        return tempo;
    }
}
