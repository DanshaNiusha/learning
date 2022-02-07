package design.visit;

import design.visit.ablity.Compressor;
import design.visit.ablity.Extractor;
import design.visit.file.PPTFile;
import design.visit.file.PdfFile;
import design.visit.file.ResourceFile;
import design.visit.file.WordFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式: 访问者通过挑选工具,来应用工具内的不同功能
 * 例如: pdf word各种文件通过应用accpet不同的工具(Vistor)来实现压缩,提取等功能, visit方法就实际作用的逻辑
 */
public class ToolApplication {
    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        List<ResourceFile> resourceFiles = listAllResourceFiles();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
        }
        
        Compressor compressor = new Compressor();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
        }
    }
    
    private static List<ResourceFile> listAllResourceFiles() {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }
}