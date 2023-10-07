package design.factory.factory;

import design.factory.parser.IRuleConfigParser;
import design.factory.parser.JsonRuleConfigParser;
import design.factory.parser.JsonRuleConfigParser1;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser1();
    }
}