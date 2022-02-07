package design.visit.file;


import design.visit.ablity.Compressor;
import design.visit.ablity.Extractor;

public abstract class ResourceFile {
    
    protected String filePath;
    
    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }
    
    abstract public void accept(Extractor extractor);
    
    abstract public void accept(Compressor compressor);
    
}
