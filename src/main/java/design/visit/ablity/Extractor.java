package design.visit.ablity;

import design.visit.file.PPTFile;
import design.visit.file.PdfFile;
import design.visit.file.WordFile;

public class Extractor implements Visitor {
    @Override
    public void visit(PPTFile pptFile) {
        //...
        System.out.println("Extract PPT.");
    }
    
    @Override
    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Extract PDF.");
    }
    
    @Override
    public void visit(WordFile wordFile) {
        //...
        System.out.println("Extract WORD.");
    }
}
