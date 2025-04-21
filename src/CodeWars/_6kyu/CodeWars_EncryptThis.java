package CodeWars._6kyu;

public class CodeWars_EncryptThis {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5848565e273af816fb000449/train/java
//        Description:
//        Encrypt this!
//
//        You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:
//        Your message is a string containing space separated words.
//        You need to encrypt each word in the message using the following rules:

//        The first letter must be converted to its ASCII code.
//        The second letter must be switched with the last letter

//        Keepin' it simple: There are no special characters in the input.
//        Examples:
//        Kata.encryptThis("Hello") => "72olle"
//        Kata.encryptThis("good") => "103doo"
//        Kata.encryptThis("hello world") => "104olle 119drlo"


        String s = "hello world";
        System.out.println(encryptThis(s));
    }
    public static String encryptThis(String text) {

        String[] parole = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String parola : parole){
            for(int carattere = 0; carattere < parola.length(); carattere++){
                if(carattere == 0){
                    sb.append((int)parola.charAt(carattere));
                }
                else if(carattere == 1){
                    sb.append(parola.charAt(parola.length() - 1));
                }
                else if (carattere == parola.length() - 1){
                    sb.append(parola.charAt(1));

                } else{
                    sb.append(parola.charAt(carattere));
                }
            }
            if(parole.length > 1){
                sb.append(" ");
            }
        }
        return sb.toString().trim();

    }
}
