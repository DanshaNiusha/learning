package design.factory;

import design.factory.factory.IRuleConfigParserFactory;
import design.factory.parser.IRuleConfigParser;

/**
 * 优化后的工厂方法模式
 * 根据文件格式创建出对应格式的解析器 并解析
 */
public class Application {
    
    public static void main(String[] args) {
        String ruleConfigFileExtension = getFileExtension("../root");
        
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        IRuleConfigParser parser = parserFactory.createParser();
        
        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        String ruleConfig = parser.parse(configText);
        System.out.println(ruleConfig);
    }
    
    private static String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
