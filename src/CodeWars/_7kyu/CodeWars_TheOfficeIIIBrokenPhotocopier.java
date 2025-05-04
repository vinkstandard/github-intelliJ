package CodeWars._7kyu;

public class CodeWars_TheOfficeIIIBrokenPhotocopier {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/57ed56657b45ef922300002b/train/java
//        The bloody photocopier is broken... Just as you were sneaking around the office to print off your favourite binary code!
//        Instead of copying the original, it reverses it: '1' becomes '0' and vice versa.
//
//        Given a string of binary, return the version the photocopier gives you as a string.

        String binario = "10000000101101111110011001000";
        String risultatoAtteso = "01111111010010000001100110111";
        System.out.println("RISULTATO: " + broken(binario) + "\nRISULTATO PREVISTO: " + risultatoAtteso);

    }
    public static String broken(final String x) {
        String binario = x;
        binario = binario.replaceAll("0" , "5").replaceAll("1" , "6");
        return binario.replaceAll("5" , "1").replaceAll("6", "0"); // i 5 == 1, e i 6 == 0
    }
}
