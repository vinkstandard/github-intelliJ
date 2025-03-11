package CodeWars;

public class CodeWars_CreateAPhoneNumber {
    public static void main(String[] args) {

//        Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
        int[]numeri = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(createPhoneNumber(numeri));

    }
    public static String createPhoneNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for(int n : numbers){
            sb.append(n);
        }
        return "(" + sb.substring(0, 3) + ")" + " " + sb.substring(3, 6) + "-" + sb.substring(6, 10);
    }
}
