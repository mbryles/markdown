package com.blastingconcept.markdown;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HeadingFunction
 *
 * Implementation of {@link MarkdownFunction} that handles heading tags
 */
public class HeadingFunction implements MarkdownFunction {

    private static String HEADER_REGEX_PATTERN = "(?<headers>^#{1,6}\\s+)(?<text>.*$)";

    private Pattern pattern;

    public HeadingFunction() {

        pattern = Pattern.compile(HEADER_REGEX_PATTERN);

    }

    @Override public String markdown(String str) {

        StringBuilder sb = new StringBuilder();

        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String headers = matcher.group("headers").replaceAll("\\s", "");
            sb.append(
                    "<h" + headers.length() + ">" + matcher.group("text") + "</h" + headers.length()
                            + ">");
        }
        else {
            sb.append(str);
        }
        return sb.toString();
    }
}
