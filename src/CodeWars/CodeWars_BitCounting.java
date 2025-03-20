package CodeWars;

public class CodeWars_BitCounting {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/526571aae218b8ee490006f4/train/java
//        Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case

System.out.println(countBits(1234));
    }
    public static int countBits(int n){

        String num = Integer.toBinaryString(n);
        int bitCount = 0;
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '1'){
                bitCount++;
            }
        }
        return bitCount;
    }
}
