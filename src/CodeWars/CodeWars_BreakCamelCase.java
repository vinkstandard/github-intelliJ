package CodeWars;

public class CodeWars_BreakCamelCase {
    public static void main(String[] args) {

        String input = "camelCasing"; // == "camel Casing"
//        String input = "identifier"; == "identifier"
//        String input = ""; == ""
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
