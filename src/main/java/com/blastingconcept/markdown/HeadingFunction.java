package com.blastingconcept.markdown;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
