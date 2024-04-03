package fr.titan.pdf;

import fr.titan.pdf.model.Movie;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

public class MarkdownFreemarker implements TemplateGenerator{
    @Override
    public String generate() {
        Parser p = Parser.builder().build();
        try{
            String content = transformMarkdown();
            return "<html><body>" + HtmlRenderer.builder().build().render(p.parse(content))+ "</body></html>";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }

    private String transformMarkdown() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setDirectoryForTemplateLoading(new File(getClass().getResource("/freemarker").getFile()));
            cfg.setDefaultEncoding("UTF-8");

            Template template = cfg.getTemplate("test_file_freemarker.md");
            Map<String, Object> data = Map.of("movie", Movie.goldfinger());
            StringWriter out = new StringWriter();
            template.process(data, out);

            return out.toString();
        }catch(Exception ioe){
            System.out.println(ioe.getMessage());
        }
        return "";
    }
}
