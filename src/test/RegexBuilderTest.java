package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import common.RegexBuilder;
import org.junit.Test;

public class RegexBuilderTest {

    @Test
    public void testGenericAdd() {
        final RegexBuilder regexBuilder = new RegexBuilder();
        final String expected = "[0-9]+";
        regexBuilder.addCustom(expected);
        assertEquals(expected, regexBuilder.toString());
    }

    @Test
    public void testNumMatches() {
        final RegexBuilder regexBuilder = new RegexBuilder("[0-9]+");
        final String valid = "10";
        final boolean matches = regexBuilder.compile().matches(valid);
        assertTrue(matches);
    }
}
