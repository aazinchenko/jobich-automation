package ch.jobich.automation.pages;

import ch.jobich.automation.components.FooterComponent;
import ch.jobich.automation.enums.LookingFor;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import ch.jobich.automation.data.SearchCriteria;

public class SearchResultsPage extends BasePage {

  public SearchResultsPage(Page page) {
    super(page);
  }

  public SearchResultsPage search(String term) {
    page.getByPlaceholder("Search for jobs or companies, e.g. Driver, Cook, Engineer...").fill(term);
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search").setExact(true)).click();
    return this;
  }
  public FooterComponent footer() {
    return new FooterComponent(page);
  }

  public SearchResultsPage search(SearchCriteria criteria) {
    search(criteria.query());

    if (criteria.region() != null || criteria.domain() != null || !criteria.filters().isEmpty()) {
      showFiltersToggle().click();
    }

    if (criteria.region() != null) {
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(criteria.region().label()).setExact(true)).click();
    }

    if (criteria.domain() != null) {
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(criteria.domain().label()).setExact(true)).click();
    }

    for (LookingFor filter : criteria.filters()) {
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(filter.label()).setExact(true)).click();
    }

    return this;
  }
  public Locator showFiltersToggle() {
    return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Show filters"));
  }
}