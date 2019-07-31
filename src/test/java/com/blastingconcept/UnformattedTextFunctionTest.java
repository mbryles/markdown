package com.blastingconcept;

import com.blastingconcept.markdown.MarkdownFunction;
import com.blastingconcept.markdown.UnformattedTextFunction;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class UnformattedTextFunctionTest {

    MarkdownFunction unformattedTextFunction = new UnformattedTextFunction();

    @Test
    public void testBasicMarkdown() {

        String markdownText = "Unformatted text";

        String htmlText = unformattedTextFunction.markdown(markdownText);

        assertTrue(htmlText.equals("<p>Unformatted text</p>"));
    }

}
