package CodeWars._8kyu;

public class CodeWars_OppositeNumber {
    public static void main(String[] args) {

        System.out.println(opposite(1));
        System.out.println(opposite(14));
        System.out.println(opposite(-34));
        System.out.println(opposite(0));
    }
    public static int opposite(int number){
        return (number == 0) ? 0 : number - (number * 2);
    }
}
