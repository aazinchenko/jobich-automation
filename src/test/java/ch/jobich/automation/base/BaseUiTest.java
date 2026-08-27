package ch.jobich.automation.base;

import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.core.BrowserFactory;
import ch.jobich.automation.pages.HomePage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUiTest {

  protected Page page;

  @BeforeMethod(alwaysRun = true)
  public void openFreshPage() {
    page = BrowserFactory.createPage();
  }

  @AfterMethod(alwaysRun = true)
  public void closeBrowser() {
    BrowserFactory.shutdown();
  }
  protected HomePage openHomePage() {
    HomePage homePage = new HomePage(page);
    homePage.open(ConfigReader.getInstance().config().getBaseUrl());
    return homePage;
  }

}
