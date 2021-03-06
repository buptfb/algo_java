package com.algorithms.sort;

import java.io.BufferedInputStream;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author fanbo@imoran.net
 * @date 2021/2/2 10:27
 */
public final class In {

    ///// begin: section (1 of 2) of code duplicated from In to StdIn.

    // assume Unicode UTF-8 encoding
    private static final String CHARSET_NAME = "UTF-8";

    // assume language = English, country = US for consistency with System.out.
    private static final Locale LOCALE = Locale.CHINA;

    // the default token separator; we maintain the invariant that this value
    // is held by the scanner's delimiter between calls
    private static final Pattern WHITESPACE_PATTERN
            = Pattern.compile("\\p{javaWhitespace}+");

    // makes whitespace characters significant
    private static final Pattern EMPTY_PATTERN
            = Pattern.compile("");

    // used to read the entire input. source:
    // http://weblogs.java.net/blog/pat/archive/2004/10/stupid_scanner_1.html
    private static final Pattern EVERYTHING_PATTERN
            = Pattern.compile("\\A");

    //// end: section (1 of 2) of code duplicated from In to StdIn.

    private Scanner scanner;

    /**
     * Initializes an input stream from standard input.
     */
    public In() {
        scanner = new Scanner(new BufferedInputStream(System.in), CHARSET_NAME);
        scanner.useLocale(LOCALE);
    }

    public static String[] readStrings() {
        //return new In().readAllStrings();
        return null;
    }
}
