package design.factory;

import design.factory.factory.IRuleConfigParserFactory;
import design.factory.factory.JsonRuleConfigParserFactory;
import design.factory.factory.XmlRuleConfigParserFactory;
import design.factory.factory.YamlRuleConfigParserFactory;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactoryMap { //工厂的工厂 消除ifelse
    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();
    
    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
    }
    
    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }
}