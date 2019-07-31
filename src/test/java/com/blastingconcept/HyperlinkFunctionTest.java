package com.blastingconcept;

import com.blastingconcept.markdown.HyperLinkFunction;
import com.blastingconcept.markdown.MarkdownFunction;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class HyperlinkFunctionTest {

    MarkdownFunction hyperlinkFunction = new HyperLinkFunction();

    @Test
    public void testBasicMarkdown() {


        String markdownText = "[with an inline link](http://google.com)";

        String htmlText = hyperlinkFunction.markdown(markdownText);

        assertTrue(htmlText.equals("<a href=\"http://google.com\">with an inline link</a>"));

    }

    @Test
    public void testEmbeddedMarkdown() {


        String markdownText = "This is a paragraph [with an inline link](http://google.com). Neat, eh?";

        String htmlText = hyperlinkFunction.markdown(markdownText);

        assertTrue(htmlText.equals("This is a paragraph <a href=\"http://google.com\">with an inline link</a>. Neat, eh?"));

    }

}
