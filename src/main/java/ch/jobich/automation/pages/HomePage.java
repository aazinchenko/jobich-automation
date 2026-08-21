package ch.jobich.automation.pages;

import com.microsoft.playwright.Page;

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
}
