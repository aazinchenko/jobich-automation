package ch.jobich.automation.pages;

import ch.jobich.automation.components.FooterComponent;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WizardResultsPage extends BasePage {

  public WizardResultsPage(Page page) {
    super(page);
  }

  public Locator matchingJobsHeading() {
    return page.getByText("matching jobs");
  }

  public boolean hasNoResults() {
    return page.getByText("No jobs match your filters right now").isVisible();
  }

  public int matchingJobsCount() {
    if (hasNoResults()) {
      return 0;
    }
    String text = matchingJobsHeading().textContent();
    String digitsOnly = text.replaceAll("[^0-9]", "");
    return digitsOnly.isEmpty() ? 0 : Integer.parseInt(digitsOnly);
  }

  public FooterComponent footer() {
    return new FooterComponent(page);
  }


}