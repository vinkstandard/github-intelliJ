package CodeWars._6kyu;

public class CodeWars_CamelCase_Method {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/587731fda577b3d1b0001196/train/java
//        Write a method(or function, depending on the language) that converts a string to camelCase, that is, all
//        words must have their first letter capitalized and spaces must be removed.
//
//        Examples(input-- > output):
//        "hello case"-- > "HelloCase"
//        "camel case word"-- > "CamelCaseWord"

//        miei esempi..
//        " camel case word": spazio avanti
//        "ab  c": doppio spazio in mezzo

        String s = " camel case word";
        System.out.println(camelCase(s));

    }
    public static String camelCase(String str) {

        StringBuilder sb = new StringBuilder();
        String[] split = str.split(" ");
        for(String stringa : split){
            System.out.println(stringa);
            if(stringa.isEmpty()){
                continue;
            }
            sb.append(Character.toUpperCase(stringa.charAt(0))).append(stringa.substring(1).toLowerCase());
        }
        return sb.toString();
    }
}
