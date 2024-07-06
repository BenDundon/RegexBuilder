package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A utility class for building and using human-readable regular expressions.
 * @author Ben Dundon
 * @version 0.0.1
 */
public class RegexBuilder {

    private final StringBuilder regex;
    private Pattern pattern;

    public RegexBuilder(final String regex) {
        this.regex = new StringBuilder(regex);
    }

    /**
     * Construct a RegexBuilder from an existing Regex pattern
     * @param pattern Regex pattern to build from
     */
    public RegexBuilder(final Pattern pattern) {
        this.regex = new StringBuilder(pattern.pattern());
        this.pattern = pattern;
    }

    public RegexBuilder(final int capacity) {
        this.regex = new StringBuilder(capacity);
    }

    public RegexBuilder() {
        this.regex = new StringBuilder();
    }

    public RegexBuilder addCustom(String regex) {
        this.regex.append(regex);
        return this;
    }

    public String toString() {
        return regex.toString();
    }

    public RegexBuilder compile() {
        this.pattern = Pattern.compile(regex.toString());
        return this;
    }

    public Matcher getMatcher(final String input) {
        return this.pattern.matcher(input);
    }

    public boolean matches(final String input) {
        return this.getMatcher(input).matches();
    }
}

