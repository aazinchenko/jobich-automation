package ch.jobich.automation.pages;

import ch.jobich.automation.components.FooterComponent;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage {

  public HomePage(Page page) {
    super(page);
  }

  public HomePage open(String url) {
    page.navigate(url);
    acceptCookiesIfPresent();
    return this;
  }

  private void acceptCookiesIfPresent() {
    Locator acceptButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept"));
    if (acceptButton.isVisible()) {
      acceptButton.click();
    }
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
