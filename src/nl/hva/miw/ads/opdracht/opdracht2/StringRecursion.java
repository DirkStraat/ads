package nl.hva.miw.ads.opdracht.opdracht2;

/**
 * Class that contains methods for strings.
 * All implementations use some form of recursion.
 * This class is modified by Dirk van der Straaten, Studentnumber 500837825
 *
 */
public class StringRecursion {

    /**
     * Count recursively how many times a char c is inside String s.
     *
     * Hint: First check the first letter in the string against the letter c and then
     * apply the same to the remainder of the string.
     *
     * @param s
     * @param c
     * @return
     */
    public int countChar(String s, char c ) {
        if(s.length()==0) {
            return 0;
        }

        if ((s.substring(0,1).equals(Character.toString(c)))) {
            return 1 + countChar(s.substring(1), c);
        } else return countChar(s.substring(1), c);
    }


    /**
     * Count recursively how many times a char c is inside String s. Ignores case (so 'A' matches 'a')
     *
     * Hint: First check the first letter in the string against the letter c and then
     * apply the same to the remainder of the string.
     *
     * @param s
     * @param c
     * @return
     */
    public int countCharIgnoreCase(String s, char c ) {
        String slow = s.toLowerCase();
        char clow = Character.toLowerCase(c);

        return countChar(slow, clow);

    }


    /**
     * isAlternating returns if a string consists of 2 (different) characters alternating.
     * So for example "ababababa" or "xy" but also "a" is allowed or even "".
     * But "aa" or "abaab" or "abc" are not correct.
     *
     * Hint: use a recursive helper method (Liang 18.5).
     *
     * The algorithm is:
     *       Check if string is 2 or more characters long.
     *       If so, remember the first and second character (must be different!); call them A and B.
     *
     *       Now use the helper method to:
     *          - check the first character of the string if it matches letter A,
     *            if so then check if the remainder of the string is an "alternating string" starting with B.
     *            (do this by using recursion).
     *
     *          - Call the helper method recursively and think about now to use the parameters.
     *
     *
     *        The unittests can be used to see if your algorithm is correct.
     *
     * @param s
     * @return
     */
    public boolean isAlternating( String s ) {
        if (s.length()>=2){
            char first = s.charAt(0);
            char second = s.charAt(1);
            if (first != second) {
                return isAlternating(s.substring(2), first, second);
            } else return false;
        } else return true;
    }

    /**
     * Helper method.  Recursively checks if the string starts with a character "first" and
     * that the remainder (recursively) starts with "second", alternating.
     *
     * @param s
     * @param first
     * @param second
     * @return
     */
    private boolean isAlternating(String s, char first, char second) {
        if (s.length() >= 2) {
            if (first == s.charAt(0) && second == s.charAt(1)) {
                return isAlternating(s.substring(2), first, second);
            } else return false;
        } else if (s.length() == 1 && s.charAt(0) == first) {
            return true;
        } else if (s.length() == 0) {
            return true;
        } else return false;
    }
}
