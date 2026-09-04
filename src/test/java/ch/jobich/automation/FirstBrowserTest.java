package ch.jobich.automation;

import ch.jobich.automation.base.BaseUiTest;
import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.core.BrowserFactory;
import ch.jobich.automation.listeners.RetryAnalyzer;
import ch.jobich.automation.pages.HomePage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstBrowserTest extends BaseUiTest {

  @Test(retryAnalyzer = RetryAnalyzer.class, groups = "smoke")
  public void homePageTitleContainsJobich() {

    HomePage homePage = openHomePage();

    Assert.assertTrue(homePage.isOpened());
    //Assert.assertTrue(false, "Intentionally broken to test retry and screenshot");

  }
}