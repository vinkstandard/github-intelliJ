package CodeWars._8kyu;

import java.util.Arrays;

public class CodeWars_WelcomeToTheCity {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5302d846be2a9189af0001e4/train/java
//        Create a method that takes as input a name, city, and state to welcome a person.
//        Note that name will be an array consisting of one or more values that should be joined together with one space between each,
//        and the length of the name array in test cases will vary.
//
//        Example:
//        ['John', 'Smith'], 'Phoenix', 'Arizona'
//        This example will return the string:
//        "Hello, John Smith! Welcome to Phoenix, Arizona!"

        System.out.println();
        String[] nome = {"John", "Giuseppe", "Smith"};
        String citta = "Phoenix";
        String stato = "Arizona";
        System.out.println(sayHello(nome,citta,stato));
    }
    public static String sayHello(String [] name, String city, String state){
        StringBuilder nomeCompleto = new StringBuilder();
        for(String nome : name){nomeCompleto.append(nome).append(" ");}
        return "Hello, " + nomeCompleto.toString().trim() + "! Welcome to " + city + ", " + state + "!";
    }
}
