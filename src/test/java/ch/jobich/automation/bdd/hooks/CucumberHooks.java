package ch.jobich.automation.bdd.hooks;

import ch.jobich.automation.core.BrowserFactory;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {
  private final TestContext testContext;

  public CucumberHooks(TestContext testContext) {
    this.testContext = testContext;
  }

  @Before
  public void openFreshPage() {
    testContext.setPage(BrowserFactory.createPage());
  }

  @After
  public void closeBrowser(Scenario scenario) {
    if (scenario.isFailed()) {
      saveScreenshot(scenario);
    }
    BrowserFactory.closeContext();
  }

  private void saveScreenshot(Scenario scenario) {
    try {
      var page = testContext.getPage();
      page.waitForLoadState(LoadState.NETWORKIDLE);
      byte[] png = page.screenshot();
      scenario.attach(png, "image/png", scenario.getName());
    } catch (Exception e) {
      System.out.println("Could not save screenshot: " + e.getMessage());
    }
  }
}
