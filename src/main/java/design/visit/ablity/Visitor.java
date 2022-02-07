package design.visit.ablity;

import design.visit.file.PPTFile;
import design.visit.file.PdfFile;
import design.visit.file.WordFile;

public interface Visitor {
    
    void visit(PdfFile pdfFile);
    
    void visit(PPTFile pdfFile);
    
    void visit(WordFile pdfFile);
}
