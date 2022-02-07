package design.factory.factory;

import design.factory.parser.IRuleConfigParser;
import design.factory.parser.YamlRuleConfigParser;

public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}