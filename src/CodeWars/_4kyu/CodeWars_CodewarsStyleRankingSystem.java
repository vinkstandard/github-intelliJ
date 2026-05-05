package CodeWars._4kyu;

public class CodeWars_CodewarsStyleRankingSystem {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/51fda2d95d6efda45e00004e/train/java

        User utente = new User();
        System.out.println(">>> L'utente è rank: " + utente.rank());


    }
}

class User {

    private int rankAttuale = -8;
    private int progressoAttuale = 0;

    public User() {}

    public int rank(){
        return rankAttuale;
    }
    public int progress(){
        return 0;
    }
    public void incProgress(){

    }

}
