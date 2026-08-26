package ch.jobich.automation.pages;

import ch.jobich.automation.components.FooterComponent;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage {

  public HomePage(Page page) {
    super(page);
  }

  public void open(String url) {
    page.navigate(url);
  }

  public boolean isOpened() {
    return page.title().contains("Jobich");
  }
  public PreferencesWizardPage clickSetPreferences() {
    page.getByText("Set preferences", new Page.GetByTextOptions().setExact(true)).click();
    return new PreferencesWizardPage(page);
  }

  public SearchResultsPage clickSearchJobs() {
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Search jobs")).click();
    return new SearchResultsPage(page);
  }

  public FooterComponent footer() {
    return new FooterComponent(page);
  }
}
