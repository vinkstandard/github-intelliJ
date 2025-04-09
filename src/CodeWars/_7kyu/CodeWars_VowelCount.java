package CodeWars._7kyu;

public class CodeWars_VowelCount {
    public static void main(String[] args) {
        //        https://www.codewars.com/kata/54ff3102c1bad923760001f3/train/java
        String s = "o a kak ushakov lil vo kashu kakao";
        System.out.println(getCount(s));
    }

    public static int getCount(String str) {
        int contoVocali = 0;
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            switch (Character.toLowerCase(c)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    contoVocali++;
            }
        }
        return contoVocali;
    }
}



