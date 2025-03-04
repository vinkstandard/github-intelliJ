package CodeWars;

public class CodeWars_DetermineIfAPokerHandIsFlush {
    public static void main(String[] args) {

//        ["AS", "3S", "9S", "KS", "4S"]  ==> true
//        ["AD", "4S", "7H", "KS", "10S"] ==> false
        String[]cards = {"AD", "4S", "7H", "KS", "10S"};
        boolean good = CheckIfFlush(cards);
        System.out.println(good);
    }
    public static boolean CheckIfFlush(String[] cards){
        char suit = cards[0].charAt(cards[0].length()-1);
        for(String s : cards){
            if(s.charAt(s.length()-1) != suit){
                return false;
            }
        }
        return true;
    }
}
