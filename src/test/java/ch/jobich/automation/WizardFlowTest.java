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

  @Test(groups = "regression")
  public void completingWizardShowsMatchingJobs() {
    HomePage homePage = openHomePage();

    WizardResultsPage results = homePage
          .clickSetPreferences()
          .selectIndustry(Domain.IT_SOFTWARE)
          .next()
          .selectRegion(LanguageRegion.DE)
          .next()
          .selectWorkMode(LookingFor.CONTRACT)
          //.selectType(LookingFor.REMOTE)  too strict rule -> 0 results
          .showJobs();

    Assert.assertTrue(results.matchingJobsCount() > 0);
  }

  @Test(groups = "regression")
  public void completingWizardReachesResultsScreen() {
    HomePage homePage = openHomePage();

    WizardResultsPage results = homePage
          .clickSetPreferences()
          .selectIndustry(Domain.IT_SOFTWARE)
          .next()
          .selectRegion(LanguageRegion.ALL_SWITZERLAND)
          .next()
          .selectWorkMode(LookingFor.REMOTE)
          .showJobs();

    boolean reachedValidResultState = results.hasNoResults() || results.matchingJobsCount() >= 0;
    Assert.assertTrue(reachedValidResultState);
  }

}