package configs;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources({"system:properties", "file:gradle.properties"})
@org.aeonbits.owner.Config.HotReload

public interface Config extends org.aeonbits.owner.Config {

  @Key("web.threads")
  String webThreads();

  @Key("browser.name")
  String browserName();
}
