package CodeWars._6kyu;

import java.util.Arrays;

public class CodeWars_TheOfficeVFindAChair {

    static class Room {
        final String numeroOccupanti;
        final int numeroSedie;

        public Room(String numeroOccupanti, int numeroSedie) {
            this.numeroOccupanti = numeroOccupanti;
            this.numeroSedie = numeroSedie;
        }
    }

    public static void main(String[] args) {

//    https://www.codewars.com/kata/57f6051c3ff02f3b7300008b
//       So you've found a meeting room - phew! You arrive there ready to present, and find that someone has taken one or more of the chairs!!
//       You need to find some quick.... check all the other meeting rooms to see if all the chairs are in use.
//
//       Your meeting room can take up to 8 chairs. need will tell you how many have been taken. You need to find that many.
//
//       Find the spare chairs from the array of meeting rooms. Each meeting room tuple will have the number of occupants as a string.
//       Each occupant is represented by 'X'. The room tuple will also have an integer telling you how many chairs there are in the room.
//
//       You should return an array of integers that shows how many chairs you take from each room in order, up until you have the required amount.
//       example:
//
//       [['XXX', 3], ['XXXXX', 6], ['XXXXXX', 9], ['XXX',2]] when you need 4 chairs:
//       result -> [0, 1, 3] no chairs free in room 0, take 1 from room 1, take 3 from room 2. no need to consider room 3 as you have your 4 chairs already.
//
//       If you need no chairs, return "Game On". If there aren't enough spare chairs available, return "Not enough!".
//        Room[] rooms = new Room[] {
//                new Room("XXX", 3),
//                new Room("XXXXX", 6),
//                new Room("XXXXXX", 9)
//        };
//        System.out.println("RISULTATO: " + meeting(rooms,4) + "\nRISULTATO PREVISTO: {0, 1, 3}");

        Room[] rooms = new Room[]{
                new Room("XXX", 1),
                new Room("XXXXXX", 6),
                new Room("X", 2),
                new Room("XXXXXX", 8),
                new Room("X", 3),
                new Room("XXX", 1)
        };
        System.out.println("RISULTATO: " + meeting(rooms, 5) + "\nRISULTATO PREVISTO: {0, 0, 1, 2, 2}");
    }

    public static Object meeting(Room[] x, int need) {

        if (need == 0) return "Game On"; // se non ci servono sedie

        int indiceStanza = 0, sedieOttenute = 0;
        int[] stanzeReturn = new int[x.length];

        for (Room stanza : x) {
            int sedieLibere = stanza.numeroSedie - stanza.numeroOccupanti.length(); // metodo per estrarre le sedie disponibili

            if (sedieLibere > 0) {
                sedieOttenute += sedieLibere;
                stanzeReturn[indiceStanza] += sedieLibere;
            }
            if (sedieOttenute == need) {
                System.out.println("WIN?");
                return rimuoviVuoti(stanzeReturn);
            }

            indiceStanza++;
        }


        return "Not enough!";
    }

    public static int[] rimuoviVuoti(int[] stanze) {

        int fine = stanze.length;
        while (fine > 0 && stanze[fine - 1] == 0) {
            fine--;
        }
        return Arrays.copyOf(stanze, fine);
    }
}