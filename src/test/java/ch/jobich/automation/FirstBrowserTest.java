package ch.jobich.automation;

import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.core.BrowserFactory;
import ch.jobich.automation.pages.HomePage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstBrowserTest {

  @Test
  public void homePageTitleContainsJobich() {
    Page page = BrowserFactory.createPage();

    HomePage homePage = new HomePage(page);
    homePage.open(ConfigReader.getInstance().config().getBaseUrl());

    Assert.assertTrue(homePage.isOpened());

    BrowserFactory.shutdown();
  }
}