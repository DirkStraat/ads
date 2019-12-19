package nl.hva.miw.ads.opdracht.opdracht2;

/**
 * Deze klasse test Stringrecursion.
 * Deze klasse is aangepast door Dirk van der Straaten, studentnummer 500837825
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class StringRecursionTest {

    @Test
    public void countChar() {

        StringRecursion sr = new StringRecursion();

        int expected = 0;
        int actual = sr.countChar("The quick brown fox jumps over the lazy dog." , 'X');
        assertEquals( expected, actual );

        expected = 1;
        actual = sr.countChar("The quick brown fox jumps over the lazy dog." , 'x');
        assertEquals( expected, actual );

        expected = 3;
        actual = sr.countChar("The quick brown fox jumps over the lazy dog." , 'e');
        assertEquals( expected, actual );

        expected = 1;
        actual = sr.countChar("The quick brown fox jumps over the lazy dog." , '.');
        assertEquals( expected, actual );
    }

    @Test
    public void countCharIgnoreCase() {
        StringRecursion sr = new StringRecursion();

        int expected = 1;
        int actual = sr.countCharIgnoreCase("The quick brown fox jumps over the lazy dog." , 'X');
        assertEquals( expected, actual );

        expected = 1;
        actual = sr.countCharIgnoreCase("The quick brown fox jumps over the lazy dog." , 'x');
        assertEquals( expected, actual );

        expected = 3;
        actual = sr.countCharIgnoreCase("The quick brown fox jumps over the lazy dog." , 'e');
        assertEquals( expected, actual );

        expected = 1;
        actual = sr.countCharIgnoreCase("The quick brown fox jumps over the lazy dog." , '.');
        assertEquals( expected, actual );
    }

    @Test
    public void isAlternating() {
        StringRecursion sr = new StringRecursion();

        assertTrue( sr.isAlternating( "" ));
        assertTrue( sr.isAlternating( "a" ));
        assertTrue( sr.isAlternating( "ab" ));
        assertTrue( sr.isAlternating( "aba" ));
        assertTrue( sr.isAlternating( "ababa" ));
        assertFalse( sr.isAlternating( "aa" ));
        assertFalse( sr.isAlternating( "abc" ));
        assertFalse( sr.isAlternating( "abcba" ));
        assertFalse( sr.isAlternating( "abaaba" ));
        assertFalse( sr.isAlternating( "aabb" ));
    }
}