package CodeWars._5kyu;
import java.util.regex.*;

public class CodeWars_RegexPasswordValidation {

//        https://www.codewars.com/kata/52e1476c8147a7547a000811
//        You need to write regex that will validate a password to make sure it meets the following criteria:
//
//        At least six characters long
//        contains a lowercase letter
//        contains an uppercase letter
//        contains a digit
//        only contains alphanumeric characters (note that '_' is not alphanumeric)

    static private Pattern pattern;
    static void parseRegex() {
        pattern = Pattern.compile(PasswordRegex.REGEX);
    }
    private void doTest(String password, boolean expected) {
        boolean actual = pattern.matcher(password).matches();
        assertEquals(expected, actual, "for password: \"" + password + "\"");
    }

    private void assertEquals(boolean expected, boolean actual, String s) {
    }

    void sampleTests() {
        doTest("fjd3IR9", true);
        doTest("ghdfj32", false);
        doTest("DSJKHD23", false);
        doTest("dsF43", false);
        doTest("4fdg5Fj3", true);
        doTest("DHSJdhjsU", false);
        doTest("fjd3IR9.;", false);
        doTest("fjd3  IR9", false);
        doTest("djI38D55", true);
        doTest("djI3_8D55", false);
        doTest("djI38D55@@", false);
        doTest("a2.d412", false);
        doTest("JHD5FJ53", false);
        doTest("!fdjn345", false);
        doTest("jfkdfj3j", false);
        doTest("123", false);
        doTest("abc", false);
        doTest("123abcABC", true);
        doTest("ABC123abc", true);
        doTest("Password123", true);
    }

    static class PasswordRegex {
        // asssign your pattern string to REGEX, it will be
// compiled to a Pattern and matched with matches()
        static final String REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
    }

}
