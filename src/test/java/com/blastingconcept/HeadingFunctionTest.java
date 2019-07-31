package com.blastingconcept;

import com.blastingconcept.markdown.HeadingFunction;
import com.blastingconcept.markdown.MarkdownFunction;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class HeadingFunctionTest {

    MarkdownFunction headingFunction = new HeadingFunction();

    @Test
    public void testBasicMarkdown() {

        String markdownText = "# Heading 1";

        String htmlText = headingFunction.markdown(markdownText);

        assertTrue(htmlText.equals("<h1>Heading 1</h1>"));

    }

    @Test
    public void testMarkdownWithHigherHeadings() {

        String markdownText2 = "## Heading 2";

        String htmlText2 = headingFunction.markdown(markdownText2);

        assertTrue(htmlText2.equals("<h2>Heading 2</h2>"));


        String markdownText3 = "### Heading 3";

        String htmlText3 = headingFunction.markdown(markdownText3);

        assertTrue(htmlText3.equals("<h3>Heading 3</h3>"));


        String markdownText4 = "#### Heading 4";

        String htmlText4 = headingFunction.markdown(markdownText4);

        assertTrue(htmlText4.equals("<h4>Heading 4</h4>"));


        String markdownText5 = "##### Heading 5";

        String htmlText5 = headingFunction.markdown(markdownText5);

        assertTrue(htmlText5.equals("<h5>Heading 5</h5>"));
    }

    @Test
    public void testMarkdownWithSpaces() {

        //extra spaces are allowed before the heading text

        String markdownText = "#                  Heading 1";

        String htmlText = headingFunction.markdown(markdownText);

        assertTrue(htmlText.equals("<h1>Heading 1</h1>"));


        String markdownText5 = "#####        Heading 5";

        String htmlText5 = headingFunction.markdown(markdownText5);

        assertTrue(htmlText5.equals("<h5>Heading 5</h5>"));

    }

    @Test
    public void testMalformedMarkdownWithSpaces() {



        String markdownText = "# #### Heading 1";

        String htmlText = headingFunction.markdown(markdownText);

        assertTrue(htmlText.equals("<h1>#### Heading 1</h1>"));

    }

}
