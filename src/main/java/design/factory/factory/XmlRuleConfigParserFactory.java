package design.factory.factory;

import design.factory.parser.IRuleConfigParser;
import design.factory.parser.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
  @Override
  public IRuleConfigParser createParser() {
    return new XmlRuleConfigParser();
  }
}