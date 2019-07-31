package com.blastingconcept.markdown;

/**
 * MarkdownFunction
 *
 * Defines the basic contract for markdown functions
 */
@FunctionalInterface
public interface MarkdownFunction {
    String markdown(String str);
}
