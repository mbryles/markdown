package com.blastingconcept.markdown;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * HyperLinkFunction
 *
 * Implementation of {@link MarkdownFunction} that handles hyper link tags
 */
public class HyperLinkFunction implements MarkdownFunction {

    private static String HYPERLINK_REGEX_PATTERN =
            "(?<leadingtext>^.*)\\[(?<linkname>.+)\\]\\((?<linkurl>(http|https):\\/\\/.+)\\)(?<trailingtext>.*$)";

    private Pattern pattern;

    public HyperLinkFunction() {

        pattern = Pattern.compile(HYPERLINK_REGEX_PATTERN);

    }

    @Override public String markdown(String str) {

        StringBuilder sb = new StringBuilder();

        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String leadingText = matcher.group("leadingtext");
            String trailingText = matcher.group("trailingtext");
            String linkName = matcher.group("linkname");
            String linkUrl = matcher.group("linkurl").replaceAll("\\s", "");


            sb.append(leadingText + "<a href=\"" + linkUrl + "\">" + linkName + "</a>"
                    + trailingText);
        }
        else {
            sb.append(str);

        }
        return sb.toString();
    }
}
