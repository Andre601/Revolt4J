package ch.andre601.revolt4j.api.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Convenience class to format text in various Markdown-styles such as bold, italic or strikethrough.
 * 
 * <p>Note that this class does only cover the basics of the entire Markdown formatting Revolt offers.
 * <br>For a complete list of all supported formatting options, click <a href="https://developers.revolt.chat/markdown" target="_blank">here</a>.
 */
public class MarkdownUtil{
    
    /**
     * Returns the provided text as bold.
     * 
     * <p>Format: {@code **text**}
     * <br>Result: <b>text</b>
     * 
     * @param  text
     *         The text to format as bold.
     *         
     * @return The formatted text.
     */
    public static @NotNull String bold(@NotNull String text){
        return "**" + text + "**";
    }
    
    /**
     * Returns the provided text as italic.
     *
     * <p>Format: {@code *text*}
     * <br>Result: <i>text</i>
     *
     * @param  text
     *         The text to format as italic.
     *
     * @return The formatted text.
     */
    public static @NotNull String italic(@NotNull String text){
        return "*" + text + "*";
    }
    
    /**
     * Returns the provided text as strikethrough.
     *
     * <p>Format: {@code ~~text~~}
     * <br>Result: <strike>text</strike>
     *
     * @param  text
     *         The text to format as strikethrough.
     *
     * @return The formatted text.
     */
    public static @NotNull String strikethrough(@NotNull String text){
        return "~~" + text + "~~";
    }
    
    /**
     * Returns the provided text as inline code.
     *
     * <p>Format: {@code `text`}
     * <br>Result: {@code text}
     *
     * @param  text
     *         The text to format as inline code.
     *
     * @return The formatted text.
     */
    public static @NotNull String inlineCode(@NotNull String text){
        return "`" + text + "`";
    }
    
    /**
     * Returns the provided text as code block <b>without</b> any code highlighting.
     *
     * <p>Format: {@code ```\n text\n ```}
     * <br>Result: 
     * <pre><code>text</code></pre>
     *
     * @param  text
     *         The text to format as code block.
     *
     * @return The formatted text.
     */
    public static @NotNull String codeblock(@NotNull String text){
        return codeblock(text, null);
    }
    
    /**
     * Returns the provided text as bold.
     * <br>Note: No code highlighting possible in Javadocs.
     *
     * <p>Format: {@code ```<language>\n text \n```}
     * <br>Result:
     * <pre><code>text</code></pre>
     *
     * @param  text
     *         The text to format as code block.
     * @param  language
     *         The coding language to highlight the text in. Provide {@code null} for no highlighting.
     *
     * @return The formatted text.
     * 
     * @see #codeblock(String) String: codeblock(String) 
     */
    public static @NotNull String codeblock(@NotNull String text, @Nullable String language){
        return String.format(
            "```%s\n" +
            "%s\n" +
            "```",
            language == null ? "" : language,
            text
        );
    }
    
    /**
     * Returns the provided text as quote.
     *
     * <p>Format: {@code > text}
     * <br>Result: <i>No preview possible</i>
     *
     * @param  text
     *         The text to format as quote.
     *
     * @return The formatted text.
     */
    public static @NotNull String quote(@NotNull String text){
        return "> " + text.replace("\n", "\n> ");
    }
    
    /**
     * Returns the provided text as subscript.
     *
     * <p>Format: {@code ~text~}
     * <br>Result: <sub>text</sub>
     *
     * @param  text
     *         The text to format as subscript.
     *
     * @return The formatted text.
     */
    public static @NotNull String subscript(@NotNull String text){
        return "~" + text + "~";
    }
    
    /**
     * Returns the provided text as superscript.
     *
     * <p>Format: {@code ^text^}
     * <br>Result: <sup>text</sup>
     *
     * @param  text
     *         The text to format as superscript.
     *
     * @return The formatted text.
     */
    public static @NotNull String superscript(@NotNull String text){
        return "^" + text + "^";
    }
    
    /**
     * Returns the provided text as spoiler.
     *
     * <p>Format: {@code !!text!!}
     * <br>Result: <i>No preview possible</i>
     *
     * @param  text
     *         The text to format as spoiler.
     *
     * @return The formatted text.
     */
    public static @NotNull String spoiler(@NotNull String text){
        return "!!" + text + "!!";
    }
    
    /**
     * Returns the provided text as an embedded link.
     *
     * <p>Format: {@code [text](https://revolt.chat)}
     * <br>Result: <a href="https://revolt.chat" target="_blank">text</a>
     *
     * @param  text
     *         The text to format as embedded link.
     * @param  link
     *         The link to embed into the text.
     *
     * @return The formatted text.
     */
    public static @NotNull String embeddedLink(@NotNull String text, @NotNull String link){
        return "[" + text.replace("]", "\\]") + "](" + link.replace(")", "%29") + ")";
    }
    
    /**
     * Returns the provided text as a header.
     * <br>Note: The {@code #} can be any amount between 1 and 6.
     *
     * <p>Format: {@code ## text}
     * <br>Result:
     * <h2>text</h2>
     * 
     * @param  text
     *         The text to format as bold.
     * @param  level
     *         The amount of {@code #} to add. 1 is a H1 header, 2 a H2, etc.
     *
     * @return The formatted text.
     */
    public static @NotNull String header(@NotNull String text, int level){
        if(level <= 0)
            level = 1;
        
        if(level > 6)
            level = 6;
        
        return "#".repeat(level) + " " + text;
    }
    
}
