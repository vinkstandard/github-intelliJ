package CodeWars._6kyu;

public class CodeWars_StopgninnipSMysdroW {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5264d2b162488dc400000001
//        "Hey fellow warriors"  --> "Hey wollef sroirraw"
//        "This is a test        --> "This is a test"
//        "This is another test" --> "This is rehtona test"
        String s = "Hey fellow warriors";
        System.out.println(spinWords(s));

    }
    public static String spinWords(String sentence) {

        StringBuilder sb = new StringBuilder();
        if(!sentence.contains(" ")){
            if(sentence.length() > 4){
                return sb.append(sentence).reverse().toString();
            }
        }
        String[] parole = sentence.split(" ");
        for(String s : parole){
            StringBuilder sbb = new StringBuilder();
            if(s.length() <= 4){
                sb.append(s).append(" ");
            }
            else{
                sbb.append(s);
                sb.append(sbb.reverse());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
