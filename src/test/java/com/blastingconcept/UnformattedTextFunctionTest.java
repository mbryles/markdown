package com.blastingconcept;

import com.blastingconcept.markdown.MarkdownFunction;
import com.blastingconcept.markdown.UnformattedTextMarkdown;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class UnformattedTextFunctionTest {

    MarkdownFunction unformattedTextFunction = new UnformattedTextMarkdown();

    @Test
    public void testBasicMarkdown() {

        String markdownText = "Unformatted text";

        String htmlText = unformattedTextFunction.markdown(markdownText);

        assertTrue(htmlText.equals("<p>Unformatted text</p>"));
    }

}
