package design.factory.factory;

import design.factory.parser.IRuleConfigParser;
import design.factory.parser.JsonRuleConfigParser;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}