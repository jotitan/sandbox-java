package fr.titan.pdf;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class Markdown implements TemplateGenerator{
    @Override
    public String generate() {
        Parser p = Parser.builder().build();
        try{
            String content = new String(getClass().getResourceAsStream("/test_file.md").readAllBytes());
            return "<html><body>" + HtmlRenderer.builder().build().render(p.parse(content))+ "</body></html>";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
