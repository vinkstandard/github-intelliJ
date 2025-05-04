package CodeWars._7kyu;

public class CodeWars_TheOfficeIVFindAMeetingRoom {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/the-office-iv-find-a-meeting-room
//        Your job at E-Corp is both boring and difficult.
//        It isn't made any easier by the fact that everyone constantly wants to have a meeting with you, and that the meeting rooms are always taken!
//
//        In this kata, you will be given an array. Each value represents a meeting room.
//        Your job? Find the first empty one and return its index (N.B. There may be more than one empty room in some test cases).
//
//        'X' --> busy
//        'O' --> empty
//        If all rooms are busy, return "None available!"

        char[] c = {'X', 'X', 'O', 'X', 'X'};
        System.out.println("RISULTATO: " + meeting(c) + " \tPREVISTO: 2");
        c = new char[]{'X', 'X', 'X', 'X', 'X'};
        System.out.println("RISULTATO: " + meeting(c) + " \tPREVISTO: None available!");


    }

    public static Object meeting(char[] x) {

        for (int i = 0; i < x.length; i++) {
            if (x[i] == 'O') {
                return i;
            }
        }
        return "None available!";
    }
}
