package CodeWars._7kyu;

import java.util.HashMap;

public class CodeWars_TheOfficeIIBoredomScore {

    //    https://www.codewars.com/kata/57ed4cef7b45ef8774000014/train/java
//    Every now and then people in the office moves teams or departments.
//    Depending what people are doing with their time they can become more or less boring. Time to assess the current team.
//    You will be provided with an array of Person objects with each instance containing the name and department for a staff member.
//
//    public class Person {
//        public final String name;        // name of the staff member
//        public final String department;  // department they work in
//    }
//    Each department has a different boredom assessment score, as follows:
//
//    accounts = 1
//    finance = 2
//    canteen = 10
//    regulation = 3
//    trading = 6
//    change = 6
//    IS = 8
//    retail = 5
//    cleaning = 4
//    pissing about = 25
//
//    Depending on the cumulative score of the team, return the appropriate sentiment:
//    <=80: 'kill me now'
//    < 100 & > 80: 'i can handle this'
//    100 or over: 'party time!!'
    static class Person {

        final String name;
        final String department;

        public Person(String name, String department) {
            this.name = name;
            this.department = department;
        }
    }

    public static void main(String[] args) {
        Person[] persone = new Person[]{
                new Person("tim", "change"),
                new Person("jim", "accounts"),
                new Person("randy", "canteen"),
                new Person("sandy", "change"),
                new Person("andy", "change"),
                new Person("katie", "IS"),
                new Person("laura", "change"),
                new Person("saajid", "IS"),
                new Person("alex", "trading"),
                new Person("john", "accounts"),
                new Person("mr", "finance")
        };
        String result = boredom(persone);
        System.out.println("Risultato atteso: kill me now");
        System.out.println("Risultato ottenuto: " + result);
    }

    public static String boredom(Person[] staff) {
        int noiaTotale = 0;
        HashMap<String, Integer> mappa = new HashMap<>();
        mappa.put("accounts", 1);
        mappa.put("finance", 2);
        mappa.put("canteen", 10);
        mappa.put("regulation", 3);
        mappa.put("trading", 6);
        mappa.put("change", 6);
        mappa.put("IS", 8);
        mappa.put("retail", 5);
        mappa.put("cleaning", 4);
        mappa.put("pissing about", 25);

        for (Person p : staff) {
            noiaTotale += mappa.get(p.department);
        }
        if (noiaTotale < 80) {
            return "kill me now";
        } else if (noiaTotale < 100 && noiaTotale > 80) {
            return "i can handle this";
        } else {
            return "party time!!";
        }

    }
}
