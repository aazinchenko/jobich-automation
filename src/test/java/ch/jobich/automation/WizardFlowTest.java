package ch.jobich.automation;

import ch.jobich.automation.base.BaseUiTest;
import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.enums.Domain;
import ch.jobich.automation.enums.LanguageRegion;
import ch.jobich.automation.enums.LookingFor;
import ch.jobich.automation.pages.HomePage;
import ch.jobich.automation.pages.WizardResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WizardFlowTest extends BaseUiTest {

  @Test
  public void completingWizardShowsMatchingJobs() {
    HomePage homePage = openHomePage();

    WizardResultsPage results = homePage
          .clickSetPreferences()
          .selectIndustry(Domain.IT_SOFTWARE)
          .next()
          .selectRegion(LanguageRegion.DE)
          .next()
          .selectWorkMode(LookingFor.CONTRACT)
          .selectType(LookingFor.REMOTE)
          .showJobs();

    Assert.assertTrue(results.matchingJobsCount() > 0);
  }
}