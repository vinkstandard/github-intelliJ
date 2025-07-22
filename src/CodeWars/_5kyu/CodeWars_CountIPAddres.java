package CodeWars._5kyu;

public class CodeWars_CountIPAddres {
    public static void main(String[] args) {

//  https://www.codewars.com/kata/526989a41034285187000de4/train/java
//  Implement a function that receives two IPv4 addresses, and returns the number of addresses between them (including the first one, excluding the last one).
//
//  All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the first one.
//
//  Examples
//  * With input "10.0.0.0", "10.0.0.50"  => return  50
//  * With input "10.0.0.0", "10.0.1.0"   => return  256
//  * With input "20.0.0.10", "20.0.1.0"  => return  246

        System.out.println(ipsBetween("10.0.0.0", "10.0.0.50"));
        System.out.println(ipsBetween("20.0.0.10", "20.0.1.0"));
    }

    public static long ipsBetween(String start, String end) {

        long numero1 = 0, numero2 = 0, potenza = 3;
        String[] nums1 = start.split("\\.");
        String[] nums2 = end.split("\\.");
        for (int num = 0; num < nums1.length; num++) {
            numero1 += Integer.parseInt(nums1[num]) * (Math.pow(256, potenza));
            numero2 += Integer.parseInt(nums2[num]) * (Math.pow(256, potenza));
            potenza--;
        }
        return numero2 - numero1;
    }
}
