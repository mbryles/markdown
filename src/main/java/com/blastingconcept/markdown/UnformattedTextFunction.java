package com.blastingconcept.markdown;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UnformattedTextFunction
 *
 * Implementation of {@link MarkdownFunction} that handles unformatted text
 */
public class UnformattedTextFunction implements MarkdownFunction {
    private static String UNFORMATTED_TEXT_REGEX_PATTERN = "(?<unformattedtext>^\\w+.*)";

    private Pattern pattern;

    public UnformattedTextFunction() {

        pattern = Pattern.compile(UNFORMATTED_TEXT_REGEX_PATTERN);

    }

    @Override public String markdown(String str) {

        StringBuilder sb = new StringBuilder();

        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String unformattedText = matcher.group("unformattedtext");

            sb.append("<p>" + unformattedText.trim() + "</p>");
        }
        else {
            sb.append(str);
        }
        return sb.toString();
    }
}
