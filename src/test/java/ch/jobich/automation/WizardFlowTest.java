package ch.jobich.automation;

import ch.jobich.automation.base.BaseUiTest;
import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.pages.HomePage;
import ch.jobich.automation.pages.WizardResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WizardFlowTest extends BaseUiTest {

  @Test
  public void completingWizardShowsMatchingJobs() {
    HomePage homePage = new HomePage(page);
    homePage.open(ConfigReader.getInstance().config().getBaseUrl());

    WizardResultsPage results = homePage
          .clickSetPreferences()
          .selectIndustry("IT & Software")
          .next()
          .selectRegion("All Switzerland")
          .next()
          .selectWorkMode("Remote")
          .selectType("Full-time")
          .showJobs();

    Assert.assertTrue(results.matchingJobsCount() > 0);
  }
}