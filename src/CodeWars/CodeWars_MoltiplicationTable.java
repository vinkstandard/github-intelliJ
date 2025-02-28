package CodeWars;

public class CodeWars_MoltiplicationTable {
    public static int [][] multiplicationTable(int n){

        int[][]tavolo = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0){
                    tavolo[i][j] = j+1;
                }
                else{
                    tavolo[i][j] = (j+1) * (i+1);
                }
            }
        }
        return tavolo;
    }
}
