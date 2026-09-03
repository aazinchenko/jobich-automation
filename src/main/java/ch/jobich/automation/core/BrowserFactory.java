package ch.jobich.automation.core;

import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.config.EnvironmentConfig;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public final class BrowserFactory {
  private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
  private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
  private static final ThreadLocal<BrowserContext> context = new ThreadLocal<>();

  public static Page createPage() {
    if (playwright.get() == null) {
      playwright.set(Playwright.create());
    }
    if (browser.get() == null) {
      browser.set(launchBrowser());
    }
    BrowserContext newContext = browser.get().newContext();
    context.set(newContext);
    return newContext.newPage();
  }

  /** Closes only the context/page - reused browser process stays warm for the next test/attempt. */
  public static void closeContext() {
    if (context.get() != null) {
      context.get().close();
      context.remove();
    }
  }

  /** Full teardown - call once per thread, typically in an @AfterClass hook. */
  public static void shutdown() {
    closeContext();
    if (browser.get() != null) {
      browser.get().close();
      browser.remove();
    }
    if (playwright.get() != null) {
      playwright.get().close();
      playwright.remove();
    }
  }

  private static Browser launchBrowser() {
    EnvironmentConfig config = ConfigReader.getInstance().config();
    BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
          .setHeadless(config.isHeadless());

    return switch (config.getBrowser().toLowerCase()) {
      case "firefox" -> playwright.get().firefox().launch(options);
      case "webkit" -> playwright.get().webkit().launch(options);
      default -> playwright.get().chromium().launch(options);
    };
  }
}


/*---------------------------------------OLD Implementation without Multithreading
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
}*/
