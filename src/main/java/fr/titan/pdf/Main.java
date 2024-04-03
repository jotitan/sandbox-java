package fr.titan.pdf;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        new Thymleaf().generatePDF("thymleaf");
        new Freemarker().generatePDF("freemarker");
        //new Markdown().generatePDF("markdown");
        new MarkdownFreemarker().generatePDF("markdown-freemarker");
        new IText().generatePDF("itext");
    }
}
