package com.blastingconcept;

import com.blastingconcept.markdown.HeadingFunction;
import com.blastingconcept.markdown.HyperLinkFunction;
import com.blastingconcept.markdown.UnformattedTextMarkdown;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * MarkdownApp
 *
 * A simple commandline app for processing markdown text and generating html
 *
 * usage: java -jar markdown.jar input.txt output.txt
 */
public class MarkdownApp {

    public static void main(String[] args) throws IOException {

        String input = args[0];
        String output = args[1];

        //command line app...no need for singletons :)
        HeadingFunction headingFunction = new HeadingFunction();
        HyperLinkFunction hyperLinkFunction = new HyperLinkFunction();
        UnformattedTextMarkdown unformattedTextMarkdown = new UnformattedTextMarkdown();

        //preprocessing to normalize the text files a bit

        List<String> list = new ArrayList<>();
        List<String> cleanedLines = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (String line : Files.readAllLines(new File(input).toPath(), Charset.defaultCharset())) {
            if (!line.isEmpty() && (!line.startsWith("#") && !line.startsWith("["))) {
                sb.append(line + " ");
            }
            else {
                cleanedLines.add(sb.toString());
                cleanedLines.add(line);
                sb.setLength(0);
            }
        }

        // the actual markdown functions in action
        list = cleanedLines.stream().map(str -> headingFunction.markdown(str))
                .map(str -> hyperLinkFunction.markdown(str))
                .map(str -> unformattedTextMarkdown.markdown(str))
                .collect(Collectors.toList());

        //write the output
        Files.write(Paths.get(output), (Iterable<String>)list.stream()::iterator);
    }
}
