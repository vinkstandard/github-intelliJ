package CodeWars._5kyu;

public class CodeWars_ResistorColorCodesPart2 {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5855777bb45c01bada0002ac
//        0: black, 1: brown, 2: red, 3: orange, 4: yellow, 5: green, 6: blue, 7: violet, 8: gray, 9: white
//
//        All resistors have at least three bands, with the first and second bands indicating the first two digits of the ohms value,
//        and the third indicating the power of ten to multiply them by, for example a resistor with a value of 47 ohms,
//        which equals 47 * 10^0 ohms, would have the three bands "yellow violet black".
//
//        Most resistors also have a fourth band indicating tolerance -- in an electronics kit like yours, the tolerance will always be 5%,
//        which is indicated by a gold band. So in your kit, the 47-ohm resistor in the above paragraph would have the four bands "yellow violet black gold".
//
//        Your mission
//        Your function will receive a string containing the ohms value you need, followed by a space and the word "ohms"
//        (to avoid Codewars unicode headaches I'm just using the word instead of the ohms unicode symbol).
//        The way an ohms value is formatted depends on the magnitude of the value:
//
//        For resistors less than 1000 ohms, the ohms value is just formatted as the plain number. For example,
//        with the 47-ohm resistor above, your function would receive the string "47 ohms", and return the string `"yellow violet black gold".
//
//        For resistors greater than or equal to 1000 ohms, but less than 1000000 ohms, the ohms value is divided by 1000,
//        and has a lower-case "k" after it. For example, if your function received the string "4.7k ohms",
//        it would need to return the string "yellow violet red gold".
//
//        For resistors of 1000000 ohms or greater, the ohms value is divided by 1000000, and has an upper-case "M" after it.
//        For example, if your function received the string "1M ohms", it would need to return the string "brown black green gold".
//
//        Test case resistor values will all be between 10 ohms and 990M ohms.
//
//        More examples, featuring some common resistor values from your kit
//        "10 ohms"        "brown black black gold"
//        "100 ohms"       "brown black brown gold"
//        "220 ohms"       "red red brown gold"
//        "330 ohms"       "orange orange brown gold"
//        "470 ohms"       "yellow violet brown gold"
//        "680 ohms"       "blue gray brown gold"
//        "1k ohms"        "brown black red gold"
//        "10k ohms"       "brown black orange gold"
//        "22k ohms"       "red red orange gold"
//        "47k ohms"       "yellow violet orange gold"
//        "100k ohms"      "brown black yellow gold"
//        "330k ohms"      "orange orange yellow gold"
//        "2M ohms"        "red black green gold"
//        "4.7k ohms"      "yellow violet red gold"
//        Have fun!

        String ohm = "4.7k ohms";
        System.out.println("RETURN: " + encodeResistorColors(ohm));
    }

    public static String encodeResistorColors(String ohmsString) {

        StringBuilder numeroCompleto = new StringBuilder();
        if (ohmsString.contains("k")) { // mille
            // rimuoviamo tutto tranne i numeri e il punto
            String base = ohmsString.replaceAll("[^0-9.]", "");
            String[] parts = base.split("\\.");

            // se abbiamo una parte decimale, la moltiplichiamo per 1000
            if (parts.length == 2) {
                int parteIntera = Integer.parseInt(parts[0]);
                int parteDecimale = Integer.parseInt(parts[1]);
                numeroCompleto.append((parteIntera * 1000) + (parteDecimale * 100));
            } else {
                numeroCompleto.append(Integer.parseInt(parts[0]) * 1000);
            }
        } else if (ohmsString.contains("M")) {   // milione
            String base = ohmsString.replaceAll("[^0-9.]", "");
            String[] parts = base.split("\\.");

            // qui si moltiplica per 1000000
            if (parts.length == 2) {
                int parteIntera = Integer.parseInt(parts[0]);
                int parteDecimale = Integer.parseInt(parts[1]);
                numeroCompleto.append((parteIntera * 1000000) + (parteDecimale * 100000));
            } else {
                numeroCompleto.append(Integer.parseInt(parts[0]) * 1000000);
            }
        } else { // se non ha ne k ne M, quindi < 999
            numeroCompleto.append(ohmsString.replaceAll("[^0-9]", ""));
        }
        String primiDue = numeroCompleto.substring(0, 2);
        String esponente = String.valueOf(String.valueOf(Integer.parseInt(String.valueOf(numeroCompleto)) / Integer.parseInt(primiDue)).length() - 1);
        primiDue += esponente; // aggiungo l'esponente
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < primiDue.length(); i++) {
            char c = primiDue.charAt(i);
            switch (c) {
                case '0': sb.append("black ");break;
                case '1': sb.append("brown ");break;
                case '2': sb.append("red ");break;
                case '3': sb.append("orange ");break;
                case '4': sb.append("yellow ");break;
                case '5': sb.append("green ");break;
                case '6': sb.append("blue ");break;
                case '7': sb.append("violet ");break;
                case '8': sb.append("gray ");break;
                case '9': sb.append("white ");break;
            }
        }
        return sb.append("gold").toString();
    }
}
