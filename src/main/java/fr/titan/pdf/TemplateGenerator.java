package fr.titan.pdf;

import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;

public interface TemplateGenerator {
    String generate();

    default void generatePDF(String suffix)throws IOException {
        FileOutputStream file = new FileOutputStream(this.generateName(suffix));
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(generate());
        renderer.layout();
        renderer.createPDF(file);

        file.close();
    }

    default String generateName(String suffix){
        return String.format("test_%s.pdf",suffix);
    }
}
