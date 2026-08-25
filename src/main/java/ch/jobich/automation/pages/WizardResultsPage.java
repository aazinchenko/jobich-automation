package ch.jobich.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WizardResultsPage extends BasePage {

  public WizardResultsPage(Page page) {
    super(page);
  }

  public Locator matchingJobsHeading() {
    return page.getByText("matching jobs");
  }

  public int matchingJobsCount() {
    String text = matchingJobsHeading().textContent();
    String digitsOnly = text.replaceAll("[^0-9]", "");
    return digitsOnly.isEmpty() ? 0 : Integer.parseInt(digitsOnly);
  }


}