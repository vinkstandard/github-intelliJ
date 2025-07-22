package CodeWars._6kyu;

public class CodeWars_WhatsANameIn {
    public static void main(String[] args) {

//    https://www.codewars.com/kata/59daf400beec9780a9000045/train/java

//    What's in a name?
//    ...Or rather, what's a name in? For us, a particular string is where we are looking for a name.
//
//    Task
//    Write a function, taking two strings in parameter,
//    that tests whether or not the first string contains all of the letters of the second string, in order.
//
//    The function should return true if that is the case, and else false. Letter comparison should be case-INsensitive.
//
//    Examples
//    "Across the rivers", "chris" --> true
//    Contains all of the letters in "chris", in order.
//
//    "Next to a lake", "chris" --> false
//    Contains none of the letters in "chris".
//
//    "A crew that boards the ship", "chris" --> false
//    Contains all of the letters in "chris", but not in order.
//
//    "A live son", "Allison" --> false
//    Contains all of the correct letters in "Allison", in order, but not enough of all of them (missing an 'l').

        System.out.println(nameInStr("Across the rivers", "chris"));
        System.out.println(nameInStr("Next to a lake", "chris"));
        System.out.println(nameInStr("A crew that boards the ship", "chris"));
        System.out.println(nameInStr("A live son", "Allison"));
    }
    public static boolean nameInStr(String str, String name){
        return false;
    }
}
