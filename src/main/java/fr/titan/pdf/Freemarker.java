package fr.titan.pdf;

import fr.titan.pdf.model.Movie;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

public class Freemarker implements TemplateGenerator{
    @Override
    public String generate() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setDirectoryForTemplateLoading(new File(getClass().getResource("/freemarker").getFile()));
            cfg.setDefaultEncoding("UTF-8");

            Template template = cfg.getTemplate("test_file.ftlh");
            Map<String, Object> data = Map.of("name","Largo", "surname", "Emilio", "movie", Movie.goldfinger());
            StringWriter out = new StringWriter();
            template.process(data, out);

            return out.toString();
        }catch(Exception ioe){
            System.out.println(ioe.getMessage());
        }
        return "";
    }
}
