package CodeWars._3kyu;

import java.util.*;
import java.util.regex.*;

public class CodeWars_PapersPlease {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/59d582cafbdd0b7ef90000a0/train/java
//
//        Objective
//        Your task is to create a constructor function (or class)
//        and a set of instance methods to perform the tasks of the border checkpoint inspection officer.
//        The methods you will need to create are as follow:
//
//        Method: receiveBulletin
//        Each morning you are issued an official bulletin from the Ministry of Admission
//        This bulletin will provide updates to regulations and procedures and the name of a wanted criminal.
//        The bulletin is provided in the form of a string. It may include one or more of the following:
//        {SPOSTATO I COMMENTI NEL METODO}
//
//        Method: inspect
//        Each day, a number of entrants line up outside the checkpoint inspection booth to gain passage into Arstotzka.
//        The inspect method will receive an object representing each entrant's set of identifying documents.
//        This object will contain zero or more properties which represent separate documents. Each property will be a string value.
//        These properties may include the following:
//
//        Applies to all entrants:
//          passport
//          certificate_of_vaccination
//        Applies only to citizens of Arstotzka:
//          ID_card
//        Applies only to foreigners:
//          access_permit
//          work_pass
//          grant_of_asylum
//          diplomatic_authorization
//        The inspect method will return a result based on whether the entrant passes or fails inspection:
//        Conditions for passing inspection:
//
//        All required documents are present
//        There is no conflicting information across the provided documents
//        All documents are current (ie. none have expired) -- a document is considered expired if the expiration date is November 22, 1982 or earlier
//        The entrant is not a wanted criminal
//        If a certificate_of_vaccination is required and provided, it must list the required vaccination
//        A "worker" is a foreigner entrant who has WORK listed as their purpose on their access permit
//        If entrant is a foreigner, a grant_of_asylum or diplomatic_authorization are acceptable in lieu of an access_permit.
//        In the case where a diplomatic_authorization is used, it must include Arstotzka as one of the list of nations that can be accessed.
//
//        If the entrant passes inspection, the method should return one of the following string values:
//        If the entrant is a citizen of Arstotzka: Glory to Arstotzka.
//        If the entrant is a foreigner: Cause no trouble.
//
//
//        If the entrant fails the inspection due to expired or missing documents,
//        or their certificate_of_vaccination does not include the necessary vaccinations, return Entry denied: with the reason for denial appended.
//
//        Example 1: Entry denied: passport expired.
//        Example 2: Entry denied: missing required vaccination.
//        Example 3: Entry denied: missing required access permit.
//
//        If the entrant fails the inspection due to mismatching information between documents (causing suspicion of forgery) or if they're a wanted criminal,
//        return Detainment: with the reason for detainment appended.
//
//        If due to information mismatch, include the mismatched item. e.g.Detainment: ID number mismatch.
//        If the entrant is a wanted criminal: Detainment: Entrant is a wanted criminal.
//
//        NOTE: One wanted criminal will be specified in each daily bulletin, and must be detained when received for that day only.
//        For example, if an entrant on Day 20 has the same name as a criminal declared on Day 10, they are not to be detained for being a criminal.
//
//        Also, if any of an entrant's identifying documents include the name of that day's wanted criminal (in case of mismatched names across multiple documents),
//        they are assumed to be the wanted criminal.
//
//        In some cases, there may be multiple reasons for denying or detaining an entrant. For this exercise, you will only need to provide one reason.
//
//        If the entrant meets the criteria for both entry denial and detainment, priority goes to detaining.
//        For example, if they are missing a required document and are also a wanted criminal, then they should be detained instead of turned away.
//        In the case where the entrant has mismatching information and is a wanted criminal, detain for being a wanted criminal.



        String bulletin = "Entrants require passport\n" +
                "Allow citizens of Arstotzka, Obristan";

        // per qualche motivo il kata utilizza una map con una sola key contenente tutto, a sto punto potevano usare una string e basta...

        Map<String, String> person = new HashMap<>();
        person.put("passport",
                "ID#: GC07D-FU8AR\n" +
                "NATION: Arstotzka\n" +
                "NAME: Costanza, Josef\n" +
                "DOB: 1933.11.28\n" +
                "SEX: M\n" +
                "ISS: East Grestin\n" +
                "EXP: 1983.03.15");

        System.out.println(inspect(person));


    }
    public static void receiveBulletin(String bulletin) {
//        The bulletin is provided in the form of a string. It may include one or more of the following:
//
//        Updates to the list of nations (comma-separated if more than one) whose citizens may enter (begins empty, before the first bulletin):
//        example 1: Allow citizens of Obristan
//        example 2: Deny citizens of Kolechia, Republia

//        Updates to required documents
//        example 1: Foreigners require access permit
//        example 2: Citizens of Arstotzka require ID card
//        example 3: Workers require work pass

//        Updates to required vaccinations
//        example 1: Citizens of Antegria, Republia, Obristan require polio vaccination
//        example 2: Entrants no longer require tetanus vaccination

//        Update to a currently wanted criminal
//        example 1: Wanted by the State: Hubert Popovic
        // Your code here
    }

    public static String inspect(Map<String, String> person) {
        // aggiusto la mappa (come sarebbe dovuta essere di default)
        String[]parametri = person.get("passport").split("\n");

        HashMap<String, String> mappa = new HashMap<>();
        for(int i = 0; i < parametri.length; i++) {
            int indiceDuePunti = parametri[i].indexOf(':');                                                            // trovo la posizione dei ":"
            String chiave = parametri[i].substring(0,indiceDuePunti);                                                  // la chiave parte da 0 fino alla posizione dei ":"
            String valore = parametri[i].substring(indiceDuePunti + 1).replaceAll(" ", ""); // il valore parte dalla posizione ":" + 1 (fino alla fine)
            mappa.put(chiave,valore);
        }
        // stampa debug per la mappa
        for (Map.Entry<String, String> entry : mappa.entrySet()) {
            System.out.println("Chiave: (" + entry.getKey() + ")" + ", Valore: (" + entry.getValue() + ")") ;
        }
        return "";
    }
}
