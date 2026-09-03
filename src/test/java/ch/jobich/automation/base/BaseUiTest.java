package ch.jobich.automation.base;

import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.core.BrowserFactory;
import ch.jobich.automation.pages.HomePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseUiTest {

  protected Page page;

  public Page getPage() {
    return page;
  }

  @BeforeMethod(alwaysRun = true)
  public void openFreshPage() {
    page = BrowserFactory.createPage();
  }

  @AfterMethod(alwaysRun = true)
  public void closeBrowser(ITestResult result) {
    if (!result.isSuccess()) {
      saveScreenshot(result);
    }
    BrowserFactory.closeContext();
  }

  @AfterClass(alwaysRun = true)
  public void shutdownBrowser() {
    BrowserFactory.shutdown();
  }

  private void saveScreenshot(ITestResult result) {
    try {
      Path dir = Path.of("target", "screenshots");
      Files.createDirectories(dir);
      String fileName = result.getName() + "_" + result.getStartMillis() + ".png";
      page.waitForLoadState(LoadState.NETWORKIDLE);
      page.screenshot(new Page.ScreenshotOptions().setPath(dir.resolve(fileName)));
    } catch (Exception e) {
      System.out.println("Could not save screenshot: " + e.getMessage());
    }
  }
  protected HomePage openHomePage() {
    HomePage homePage = new HomePage(page);
    homePage.open(ConfigReader.getInstance().config().getBaseUrl());
    return homePage;
  }

}
