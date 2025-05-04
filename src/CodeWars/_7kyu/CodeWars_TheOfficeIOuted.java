package CodeWars._7kyu;

public class CodeWars_TheOfficeIOuted {

//        https://www.codewars.com/kata/the-office-i-outed
//        Your colleagues have been looking over your shoulder.
//        When you should have been doing your boring real job, you've been using the work computers to smash in endless hours of codewars.
//
//        In a team meeting, a terrible, awful person declares to the group that you aren't working. You're in trouble.
//        You quickly have to gauge the feeling in the room to decide whether or not you should gather your things and leave.
//
//        Given a Person array ( meet ) containing team members, you need to assess the overall happiness rating of the group.
//        If <= 5, return "Get Out Now!". Else return "Nice Work Champ!".
//
//        The Person class looks like:
//        class Person {
//            final String name;    // team member's name
//            final int happiness;  // happiness rating out of 10
//        }
//
//        Happiness rating will be total score / number of people in the room.
//
//        Note: that your boss is in the room ( boss ). Their score is worth double its face value (but they are still just one person!).

    static class Person {
        final String name;
        final int happiness;

        Person(String name, int happiness) {
            this.name = name;
            this.happiness = happiness;
        }
    }
    public static void main(String[] args) {

        Person[] meet = new Person[] {
                new Person("tim", 0),
                new Person("jim", 2),
                new Person("randy", 0),
                new Person("sandy", 7),
                new Person("andy", 0),
                new Person("katie", 5),
                new Person("laura", 1),
                new Person("saajid", 2),
                new Person("alex", 3),
                new Person("john", 2),
                new Person("mr", 0)
        };

        String boss = "laura";
        String result = outed(meet, boss);
        System.out.println("Risultato atteso: Get Out Now!");
        System.out.println("Risultato ottenuto: " + result);

    }
    public static String outed(Person[] meet, String boss) {
        double felicitaTotale = 0;
        for(Person p : meet){
            System.out.println(p.name + " " + p.happiness); // debug
            if(p.name.equals(boss)){
                felicitaTotale += (p.happiness * 2);
            }else{
                felicitaTotale += p.happiness;
            }
        }
        felicitaTotale /= meet.length;

        return (felicitaTotale <= 5) ? "Get Out Now!" : "Nice Work Champ!";
    }
}
