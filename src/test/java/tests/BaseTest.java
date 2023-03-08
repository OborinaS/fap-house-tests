package tests;


import com.codeborne.selenide.Configuration;
import configs.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

  public static final Config config = ConfigFactory.create(Config.class);

  private static void setUp() {

    Configuration.baseUrl = "https://studio.faphouse.com";
    Configuration.browserSize = "1366x768";

    Configuration.browser = config.browserName();
  }

  @BeforeAll
  static void beforeAll() {
    setUp();
  }
}
