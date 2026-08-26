package ch.jobich.automation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SearchResultsPage extends BasePage {

  public SearchResultsPage(Page page) {
    super(page);
  }

  public SearchResultsPage search(String term) {
    page.getByPlaceholder("Search for jobs or companies, e.g. Driver, Cook, Engineer...").fill(term);
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search").setExact(true)).click();
    return this;
  }
}