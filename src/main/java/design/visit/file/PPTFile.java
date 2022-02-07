package design.visit.file;

import design.visit.ablity.Compressor;
import design.visit.ablity.Extractor;

public class PPTFile extends ResourceFile {
    public PPTFile(String filePath) {
        super(filePath);
    }
    
    @Override
    public void accept(Extractor extractor) {
        extractor.visit(this);
    }
    
    @Override
    public void accept(Compressor compressor) {
        compressor.visit(this);
    }
    
}
