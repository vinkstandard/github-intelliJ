package CodeWars._6kyu;

import java.util.HashMap;

public class CodeWars_GoodVsEvil {
    public static void main(String[] args) {

//        Description
//        Middle Earth is about to go to war. The forces of good will have many battles with the forces of evil.
//        Different races will certainly be involved. Each race has a certain worth when battling against others.
//        On the side of good we have the following races, with their associated worth:
//
//        Hobbits: 1
//        Men: 2
//        Elves: 3
//        Dwarves: 3
//        Eagles: 4
//        Wizards: 10
//        On the side of evil we have:
//
//        Orcs: 1
//        Men: 2
//        Wargs: 2
//        Goblins: 2
//        Uruk Hai: 3
//        Trolls: 5
//        Wizards: 10
//
//        Although weather, location, supplies and valor play a part in any battle, if you add up the worth of the side of good and compare it with the worth of the side of evil,
//        the side with the larger worth will tend to win.
//
//        Thus, given the count of each of the races on the side of good, followed by the count of each of the races on the side of evil, determine which side wins.
//
//        Input:
//        The function will be given two parameters. Each parameter will be a string of multiple integers separated by a single space.
//        Each string will contain the count of each race on the side of good and evil.
//
//        The first parameter will contain the count of each race on the side of good in the following order:
//        Hobbits, Men, Elves, Dwarves, Eagles, Wizards.
//        The second parameter will contain the count of each race on the side of evil in the following order:
//
//        Orcs, Men, Wargs, Goblins, Uruk Hai, Trolls, Wizards.
//        All values are non-negative integers. The resulting sum of the worth for each side will not exceed the limit of a 32-bit integer.
//
//        Output:
//        Return "Battle Result: Good triumphs over Evil" if good wins, "Battle Result: Evil eradicates all trace of Good" if evil wins, or "Battle Result: No victor on this battlefield" if it ends in a tie.

        System.out.println("Risultato: (" + battle("1 1 1 1 1 1", "1 1 1 1 1 1 1") + ")\tAtteso: (\"Battle Result: Evil eradicates all trace of Good\")");
        System.out.println("Risultato: (" + battle("0 0 0 0 0 10", "0 1 1 1 1 0 0") + ")\tAtteso: (\"Battle Result: Good triumphs over Evil\")");
        System.out.println("Risultato: (" + battle("1 0 0 0 0 0", "1 0 0 0 0 0 0") + ")\tAtteso: (\"Battle Result: No victor on this battle field\")");
    }
    public static String battle(String goodAmounts, String evilAmounts) {

        int totaleGood = 0, totaleBad = 0;
        String[] totaliArmate = (goodAmounts + " " + evilAmounts).split(" ");

        for(int i = 0; i < totaliArmate.length; i++){
            switch (i){
                case 0 -> totaleGood += Integer.parseInt(totaliArmate[i]);
                case 1 -> totaleGood += (2 *Integer.parseInt(totaliArmate[i]));
                case 2 -> totaleGood += (3 *Integer.parseInt(totaliArmate[i]));
                case 3 -> totaleGood += (3 *Integer.parseInt(totaliArmate[i]));
                case 4 -> totaleGood += (4 *Integer.parseInt(totaliArmate[i]));
                case 5 -> totaleGood += (10 *Integer.parseInt(totaliArmate[i]));
                case 6 -> totaleBad += Integer.parseInt(totaliArmate[i]);
                case 7 -> totaleBad += (2 * Integer.parseInt(totaliArmate[i]));
                case 8 -> totaleBad += (2 * Integer.parseInt(totaliArmate[i]));
                case 9 -> totaleBad += (2 * Integer.parseInt(totaliArmate[i]));
                case 10 -> totaleBad += (3 * Integer.parseInt(totaliArmate[i]));
                case 11 -> totaleBad += (5 * Integer.parseInt(totaliArmate[i]));
                case 12 -> totaleBad += (10 * Integer.parseInt(totaliArmate[i]));
            }
        }
    if(totaleGood > totaleBad) return "Battle Result: Good triumphs over Evil";
    if(totaleGood < totaleBad) return "Battle Result: Evil eradicates all trace of Good";
    return "Battle Result: No victor on this battle field";

    }
}
