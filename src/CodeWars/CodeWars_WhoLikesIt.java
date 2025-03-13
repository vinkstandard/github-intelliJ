package CodeWars;

public class CodeWars_WhoLikesIt {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/5266876b8f4bf2da9b000362/train/java
//        []                                -->  "no one likes this"
//        ["Peter"]                         -->  "Peter likes this"
//        ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
//        ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
//        ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
        String[] names = {"Alex", "Jacob", "Mark", "Max"};
        System.out.println(whoLikesIt(names));

    }
    public static String whoLikesIt(String... names) {

        switch(names.length){
            case 0 : return "no one likes this";
            case 1 : return names[0] + " likes this";
            case 2 : return names[0] + " and " + names[1] + " like this";
            case 3 : return names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default: return names[0] + ", " + names[1] + " and " + (names.length-2) + " others like this";
        }
    }
}
