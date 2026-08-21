package ch.jobich.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public abstract class BasePage {

  protected final Page page;

  protected BasePage(Page page) {
    this.page = page;
  }

  protected Locator visible(String selector) {
    Locator locator = page.locator(selector);
    locator.first().waitFor(new Locator.WaitForOptions()
          .setState(WaitForSelectorState.VISIBLE));
    return locator;
  }

}
