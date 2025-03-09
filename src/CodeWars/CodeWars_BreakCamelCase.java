package CodeWars;

public class CodeWars_BreakCamelCase {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5208f99aee097e6552000148
//        String input = "identifier"; == "identifier"
//        String input = ""; == ""
        String input = "camelCasing"; // == "camel Casing"

        System.out.println(camelCase(input));
    }
    public static String camelCase(String input) {
        if(input.isEmpty()){
            return input;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(Character.isLowerCase(c)){
                sb.append(c);
            }
            else{
                sb.append(" ");
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
