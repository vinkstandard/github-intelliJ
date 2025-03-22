package CodeWars;

public class CodeWars_EmotionalSort {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5a86073fb17101e453000258/train/java
//        Emotional Sort ( ︶︿︶)
//        You'll have to create a function that will return an array of emotions sorted. It has two parameters, the first parameter called will expect an array of emotions where an emotion will be one of the following:
//
//        :D -> Super Happy
//        :) -> Happy
//        :| -> Normal
//        :( -> Sad
//        T_T -> Super Sad
//        Example of the array:[ "T_T", ":D", ":|", ":)", ":(" ]
//        And the second parameter will expect a boolean. If this parameter is true then the order of the emotions will be descending
//        (from Super Happy to Super Sad) if it's false then it will be ascending (from Super Sad to Super Happy)
//        Example if order is true with the above array: [ ":D", ":)", ":|", ":(", "T_T" ]
//        If order is false: [ "T_T", ":(", ":|", ":)", ":D" ]
//        Super Sad -> Sad -> Normal -> Happy -> Super Happy
//        array: [":D", ":|", ":)", ":(", ":D"]
//        order: true
//        should return [ ":D", ":D", ":)", ":|", ":(" ]
//
//        array: [":D", ":|", ":)", ":(", ":D"]
//        order: false
//        should return [ ":(", ":|", ":)", ":D", ":D" ]

        String[] emotions = {":D", ":)", ":|", ":(", "T_T"};


    }
    public static String[] sortEmotions(boolean order, String[] emotions) {
        // (ง •̀_•́)ง
        return new String[0];
    }
}
