package CodeWars._5kyu;

import java.util.List;

public class CodeWars_SimpleEncryptionQwerty {
    public static void main(String[] args) {


//        System.out.println("Risultato cifratura di [Ball] chiave 444 = [" + encrypt("Ball", 444) + "] | Expected : [" + ">gff" + "]");
//        System.out.println("Risultato decifratura di [>gff] chiave 444 = [" + decrypt(">gff", 444) + "] | Expected : [" + "Ball" + "]");
        System.out.println(decrypt("axknb dO] b|ozN{xo  ", 206) + "] | Expected : [" + "abk., dU] ,|uv>{bu " + "]");

    }
    // https://www.codewars.com/kata/57f14afa5f2f226d7d0000f4/train/java

    public static final List<String> REGION_LINES = List.of("qwertyuiop", "asdfghjkl", "zxcvbnm,."); // ZXCVBNM<>

    public static String encrypt(String text, int key) {
        String fixedKey = getFixedKey(key);
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            System.out.println("analizzando il carattere: [" + c + "]") ;
            int regionIndex = getRegionIndex(Character.toLowerCase(c));
            if (regionIndex == -1) {
                System.out.println("APPESO: " + c);
                encryptedText.append(c);
            } else {
                String currentRegionLine = REGION_LINES.get(regionIndex);
                int currentPos = currentRegionLine.indexOf(Character.toLowerCase(c));
                int nuovoIndice = currentPos + Character.getNumericValue(fixedKey.charAt(regionIndex));
                while (nuovoIndice > currentRegionLine.length() - 1) {
                    nuovoIndice -= currentRegionLine.length();
                }
                char newChar = currentRegionLine.charAt(nuovoIndice);
                if (Character.isUpperCase(c)) {
                    System.out.println("CARATTARE UPPERCASE TROVATO " + c + " [" + newChar + "]") ;
                    if (!Character.isAlphabetic(newChar)) {
                        if (newChar == ',') encryptedText.append('<');
                        if (newChar == '.') encryptedText.append('>');
                    } else {
                        encryptedText.append(Character.toUpperCase(newChar));
                    }
                } else {
                    encryptedText.append(newChar);
                }
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, int key) {

        String fixedKey = getFixedKey(key);
        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            System.out.println("analizzando il carattere: [" + c + "]") ;

            int regionIndex = getRegionIndex(Character.toLowerCase(c));
            if (regionIndex == -1) {
                System.out.println("APPESO: [" + c + "]");
                decryptedText.append(c);
            } else {
                String currentRegionLine = REGION_LINES.get(regionIndex);
                int currentPos = currentRegionLine.indexOf(Character.toLowerCase(c));
                int nuovoIndice = currentPos - Character.getNumericValue(fixedKey.charAt(regionIndex));
                while (nuovoIndice < 0) {
                    nuovoIndice += currentRegionLine.length();
                }
                char newChar = currentRegionLine.charAt(nuovoIndice);
                if (Character.isUpperCase(c) || c == '<' || c == '>') {
                    System.out.println("CARATTARE UPPERCASE TROVATO " + c + " [" + newChar + "]") ;

                    if (newChar == '<') decryptedText.append(',');
                    if (newChar == '>') decryptedText.append('.');
                    if (newChar == ',') decryptedText.append('<');
                    if (newChar == '.') decryptedText.append('>');
                    if (Character.isAlphabetic(newChar)) decryptedText.append(Character.toUpperCase(newChar));
                } else {
                    decryptedText.append(newChar);
                }
            }
        }
        return decryptedText.toString();
    }

    public static String getFixedKey(int key) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + String.valueOf(key).length() != 3) {
            sb.append(0);
        }
        return sb.append(key).toString();
    }

    public static int getRegionIndex(char c) {
        for (String region : REGION_LINES) {
            if (c == '<' || c == '>') c = ',';
            if (region.contains(c + "")) return REGION_LINES.indexOf(region);
        }
        return -1;
    }
}
