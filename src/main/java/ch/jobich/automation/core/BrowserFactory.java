package ch.jobich.automation.core;

import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.config.EnvironmentConfig;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BrowserFactory {

  private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
  private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
  private static final ThreadLocal<BrowserContext> context = new ThreadLocal<>();

  private static final Logger LOG = LoggerFactory.getLogger(BrowserFactory.class);

  public static Page createPage() {
    if (playwright.get() == null) {
      playwright.set(Playwright.create());
    }
    if (browser.get() == null) {
      EnvironmentConfig config = ConfigReader.getInstance().config();
      LOG.info("Launching {} browser (headless={})", config.getBrowser(), config.isHeadless());
      browser.set(launchBrowser());
    }
    BrowserContext newContext = browser.get().newContext();
    context.set(newContext);
    return newContext.newPage();
  }

  /** Closes only the context/page - reused browser process stays warm for the next test/attempt. */
  public static void closeContext() {
    if (context.get() != null) {
      LOG.info("Closing browser context");
      context.get().close();
      context.remove();
    }
  }

  /** Full teardown - call once per thread, typically in an @AfterClass hook. */
  public static void shutdown() {
    closeContext();
    if (browser.get() != null) {
      LOG.info("Closing browser");
      browser.get().close();
      browser.remove();
    }
    if (playwright.get() != null) {
      LOG.info("Closing Playwright");
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