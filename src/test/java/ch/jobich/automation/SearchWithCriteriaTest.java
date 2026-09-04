package ch.jobich.automation;

import ch.jobich.automation.base.BaseUiTest;
import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.data.SearchCriteria;
import ch.jobich.automation.enums.Domain;
import ch.jobich.automation.enums.LanguageRegion;
import ch.jobich.automation.enums.LookingFor;
import ch.jobich.automation.pages.HomePage;
import ch.jobich.automation.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWithCriteriaTest extends BaseUiTest {

  @Test(groups = "regression")
  public void searchByCriteriaReturnsResults() {
    HomePage homePage = openHomePage();

    SearchCriteria criteria = SearchCriteria.builder()
          .query("engineer")
          .region(LanguageRegion.DE)
          .withFilter(LookingFor.REMOTE)
          .build();

    SearchResultsPage results = homePage.clickSearchJobs().search(criteria);

    Assert.assertTrue(results.currentUrl().contains("search"));
  }
}