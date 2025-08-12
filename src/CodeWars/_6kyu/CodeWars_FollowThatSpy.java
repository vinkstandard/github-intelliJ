package CodeWars._6kyu;
import java.util.*;

public class CodeWars_FollowThatSpy {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/5899a4b1a6648906fe000113
//        We are diligently pursuing our elusive operative, Matthew Knight, who also goes by the alias Roy Miller.
//        He employs a nomadic lifestyle to evade detection, constantly moving from one location to another,
//        with each of his journeys following a perplexing and non-standard sequence of itineraries.
//        Our mission is to decipher the routes he will undertake during each of his voyages.
//
//        Task
//        You've been provided with an array of itinerary routes,
//        decipher the precise destinations he will visit in the correct sequence according to his meticulously planned itineraries.
//
//        Example
//        Based on the provided routes:
//
//        [ [USA, BRA], [JPN, PHL], [BRA, UAE], [UAE, JPN] ]
//        The correct sequence of destinations is:
//
//        "USA, BRA, UAE, JPN, PHL"
//        Note:
//
//        You can safely assume that there will be no duplicate locations with distinct routes.
//        All routes provided will have non-empty itineraries.
//        There will always be at least one (1) route connecting one waypoint to another.

        System.out.println("(" + findRoutes(new String[][]{{"MNL", "TAG"}, {"CEB", "TAC"}, {"TAG", "CEB"}, {"TAC", "BOR"}})
                + ") ATTESO: (MNL, TAG, CEB, TAC, BOR)");
        System.out.println("(" + findRoutes(new String[][]{{"Chicago", "Winnipeg"}, {"Halifax", "Montreal"},
                {"Montreal", "Toronto"}, {"Toronto", "Chicago"}, {"Winnipeg", "Seattle"}})
                + ") ATTESO: (Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle)");
    }

    public static String findRoutes(String[][] routes) {
        Map<String, String> mappaDestinazioni = new HashMap<>();
        for (String[] rotta : routes) {
            mappaDestinazioni.put(rotta[0], rotta[1]);
        }
        List<String> listaDestinazioni = new ArrayList<>(mappaDestinazioni.values());
        String posizioneAttuale = "";
        for (String[] rotta : routes) {
            if (!listaDestinazioni.contains(rotta[0])) {
                posizioneAttuale = rotta[0];
                break;
            } else if (!listaDestinazioni.contains(rotta[1])) {
                posizioneAttuale = rotta[1];
                break;
            }
        }
        StringBuilder sb = new StringBuilder(posizioneAttuale);
        while (mappaDestinazioni.containsKey(posizioneAttuale)) {
            sb.append(", ").append(mappaDestinazioni.get(posizioneAttuale));
            posizioneAttuale = mappaDestinazioni.get(posizioneAttuale);
        }
        return sb.toString();
    }
}