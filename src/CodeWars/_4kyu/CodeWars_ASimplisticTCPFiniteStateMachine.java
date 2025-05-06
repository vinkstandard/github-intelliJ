package CodeWars._4kyu;


import java.util.*;

public class CodeWars_ASimplisticTCPFiniteStateMachine {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/54acc128329e634e9a000362/train/java
//        Automatons, or Finite State Machines (FSM), are extremely useful to programmers when it comes to software design.
//        You will be given a simplistic version of an FSM to code for a basic TCP session.
//
//        The outcome of this exercise will be to return the correct state of the TCP FSM based on the array of events given.
//
//        The input array of events will consist of one or more of the following strings:
//        APP_PASSIVE_OPEN, APP_ACTIVE_OPEN, APP_SEND, APP_CLOSE, APP_TIMEOUT, RCV_SYN, RCV_ACK, RCV_SYN_ACK, RCV_FIN, RCV_FIN_ACK
//
//        The states are as follows and should be returned in all capital letters as shown:
//        CLOSED, LISTEN, SYN_SENT, SYN_RCVD, ESTABLISHED, CLOSE_WAIT, LAST_ACK, FIN_WAIT_1, FIN_WAIT_2, CLOSING, TIME_WAIT
//
//        The input will be an array of events. The initial state is CLOSED. Your job is to traverse the FSM as determined by the events,
//        and return the proper final state as a string, all caps, as shown above.
//        If an event is not applicable to the current state, your code will return "ERROR".
//
//        Action of each event upon each state:
//        (the format is INITIAL_STATE: EVENT -> NEW_STATE)
//
//        CLOSED: APP_PASSIVE_OPEN -> LISTEN
//        CLOSED: APP_ACTIVE_OPEN  -> SYN_SENT
//        LISTEN: RCV_SYN          -> SYN_RCVD
//        LISTEN: APP_SEND         -> SYN_SENT
//        LISTEN: APP_CLOSE        -> CLOSED
//        SYN_RCVD: APP_CLOSE      -> FIN_WAIT_1
//        SYN_RCVD: RCV_ACK        -> ESTABLISHED
//        SYN_SENT: RCV_SYN        -> SYN_RCVD
//        SYN_SENT: RCV_SYN_ACK    -> ESTABLISHED
//        SYN_SENT: APP_CLOSE      -> CLOSED
//        ESTABLISHED: APP_CLOSE   -> FIN_WAIT_1
//        ESTABLISHED: RCV_FIN     -> CLOSE_WAIT
//        FIN_WAIT_1: RCV_FIN      -> CLOSING
//        FIN_WAIT_1: RCV_FIN_ACK  -> TIME_WAIT
//        FIN_WAIT_1: RCV_ACK      -> FIN_WAIT_2
//        CLOSING: RCV_ACK         -> TIME_WAIT
//        FIN_WAIT_2: RCV_FIN      -> TIME_WAIT
//        TIME_WAIT: APP_TIMEOUT   -> CLOSED
//        CLOSE_WAIT: APP_CLOSE    -> LAST_ACK
//        LAST_ACK: RCV_ACK        -> CLOSED
//        "EFSM TCP"
//
//        Examples:
//        ["APP_PASSIVE_OPEN", "APP_SEND", "RCV_SYN_ACK"] =>  "ESTABLISHED"
//
//        ["APP_ACTIVE_OPEN"] =>  "SYN_SENT"
//
//        ["APP_ACTIVE_OPEN", "RCV_SYN_ACK", "APP_CLOSE", "RCV_FIN_ACK", "RCV_ACK"] =>  "ERROR"

        HashMap<String, String[]> testCase = new HashMap<>();
        testCase.put("CLOSE_WAIT", new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "RCV_FIN"});
        testCase.put("ESTABLISHED", new String[]{"APP_PASSIVE_OPEN", "RCV_SYN", "RCV_ACK"});
        testCase.put("LAST_ACK", new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "RCV_FIN", "APP_CLOSE"});
        testCase.put("SYN_SENT", new String[]{"APP_ACTIVE_OPEN"});
        testCase.put("ERROR", new String[]{"APP_PASSIVE_OPEN", "RCV_SYN", "RCV_ACK", "APP_CLOSE", "APP_SEND"});
        testCase.put("FIN_WAIT_1", new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "APP_CLOSE"});
        testCase.put("FIN_WAIT_2", new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "APP_CLOSE", "RCV_ACK"});
        testCase.put("SYN_RCVD", new String[]{"APP_PASSIVE_OPEN", "RCV_SYN"});
        testCase.put("CLOSING", new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "APP_CLOSE", "RCV_FIN"});

        // l'ho settato con lo schema: chiave == risultato previsto, e valore == input

        for (Map.Entry<String, String[]> mappa : testCase.entrySet()) {
            System.out.println("RISULTATO PREVISTO: " + mappa.getKey() + ", RISULTATO OTTENUTO: " + traverseStates(mappa.getValue()));
        }

    }
    public static String traverseStates(String[] events) {

        // provo con una mappa dentro una mappa (mappa annidata)

        Map<String, Map<String, String>> transizioni = new HashMap<>();

        transizioni.computeIfAbsent("CLOSED", k -> new HashMap<>()).put("APP_PASSIVE_OPEN", "LISTEN");
        transizioni.computeIfAbsent("CLOSED", k -> new HashMap<>()).put("APP_ACTIVE_OPEN", "SYN_SENT");

        transizioni.computeIfAbsent("LISTEN", k -> new HashMap<>()).put("RCV_SYN", "SYN_RCVD");
        transizioni.computeIfAbsent("LISTEN", k -> new HashMap<>()).put("APP_SEND", "SYN_SENT");
        transizioni.computeIfAbsent("LISTEN", k -> new HashMap<>()).put("APP_CLOSE", "CLOSED");

        transizioni.computeIfAbsent("SYN_RCVD", k -> new HashMap<>()).put("APP_CLOSE", "FIN_WAIT_1");
        transizioni.computeIfAbsent("SYN_RCVD", k -> new HashMap<>()).put("RCV_ACK", "ESTABLISHED");

        transizioni.computeIfAbsent("SYN_SENT", k -> new HashMap<>()).put("RCV_SYN", "SYN_RCVD");
        transizioni.computeIfAbsent("SYN_SENT", k -> new HashMap<>()).put("RCV_SYN_ACK", "ESTABLISHED");
        transizioni.computeIfAbsent("SYN_SENT", k -> new HashMap<>()).put("APP_CLOSE", "CLOSED");

        transizioni.computeIfAbsent("ESTABLISHED", k -> new HashMap<>()).put("APP_CLOSE", "FIN_WAIT_1");
        transizioni.computeIfAbsent("ESTABLISHED", k -> new HashMap<>()).put("RCV_FIN", "CLOSE_WAIT");

        transizioni.computeIfAbsent("FIN_WAIT_1", k -> new HashMap<>()).put("RCV_FIN", "CLOSING");
        transizioni.computeIfAbsent("FIN_WAIT_1", k -> new HashMap<>()).put("RCV_FIN_ACK", "TIME_WAIT");
        transizioni.computeIfAbsent("FIN_WAIT_1", k -> new HashMap<>()).put("RCV_ACK", "FIN_WAIT_2");

        transizioni.computeIfAbsent("CLOSING", k -> new HashMap<>()).put("RCV_ACK", "TIME_WAIT");

        transizioni.computeIfAbsent("FIN_WAIT_2", k -> new HashMap<>()).put("RCV_FIN", "TIME_WAIT");

        transizioni.computeIfAbsent("TIME_WAIT", k -> new HashMap<>()).put("APP_TIMEOUT", "CLOSED");

        transizioni.computeIfAbsent("CLOSE_WAIT", k -> new HashMap<>()).put("APP_CLOSE", "LAST_ACK");

        transizioni.computeIfAbsent("LAST_ACK", k -> new HashMap<>()).put("RCV_ACK", "CLOSED");

        String statoAttuale = "CLOSED"; // si parte sempre da CLOSED
        for (String evento : events) {
            Map<String, String> mappaEvento = transizioni.get(statoAttuale);

            // è relativamente semplice da capire, se l'evento è presente nella mappa con chiave (stato) allora è un evento eseguibile, e cambiamo lo stato
            if (mappaEvento != null && mappaEvento.containsKey(evento)) {
                statoAttuale = mappaEvento.get(evento);
            } else {
                return "ERROR"; // se non è eseguibile è un errore
            }
        }
        return statoAttuale;
    }
}
