package fr.titan.pdf;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.ListNumberingType;
import fr.titan.pdf.model.Movie;

import java.io.IOException;
import java.net.URL;

public class IText implements TemplateGenerator{

    @Override
    public String generate() {
        return null;
    }

    @Override
    public void generatePDF(String suffix) throws IOException {
        try(Document doc = new Document(new PdfDocument(new PdfWriter(this.generateName(suffix))))){
            doc.add(new Paragraph("Génération de PDF avec IText"));
            Movie m = Movie.goldfinger();
            Text title = new Text(String.format("%s (%d)",m.title(), m.year()));
            title.setBold();
            title.setFontSize(20);
            Div d = new Div();
            d.add(new Paragraph(title));
            d.add(new Paragraph(String.format("Réalisateur : %s", m.director())));
            d.add(new Paragraph("Acteurs : "));
            List l = new List(ListNumberingType.ROMAN_UPPER);
            l.setListSymbol("\u2022");
            for(String a : m.actors()){
                l.add(a);
            }
            d.add(l);
            URL u = new URL("https://avatars.githubusercontent.com/u/1869588?v=4");
            Image img = new Image(ImageDataFactory.create(u));
            img.setWidth(200);
            img.setHeight(200);
            img.setFixedPosition(350,600);
            d.add(img);
            doc.add(d);
        }
    }
}
