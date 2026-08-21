package ch.jobich.automation.core;

import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.config.EnvironmentConfig;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public final class BrowserFactory {

  private static Playwright playwright;
  private static Browser browser;

  private BrowserFactory() {
  }

  public static Page createPage() {
    if (playwright == null) {
      playwright = Playwright.create();
    }
    if (browser == null) {
      browser = launchBrowser();
    }
    return browser.newPage();
  }

  public static void shutdown() {
    if (browser != null) {
      browser.close();
      browser = null;
    }
    if (playwright != null) {
      playwright.close();
      playwright = null;
    }
  }

  private static Browser launchBrowser() {
    EnvironmentConfig config = ConfigReader.getInstance().config();

    BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
          .setHeadless(config.isHeadless());

    return switch (config.getBrowser().toLowerCase()) {
      case "firefox" -> playwright.firefox().launch(options);
      case "webkit" -> playwright.webkit().launch(options);
      default -> playwright.chromium().launch(options);
    };
  }
}