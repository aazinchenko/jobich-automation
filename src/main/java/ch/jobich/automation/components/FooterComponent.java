package ch.jobich.automation.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class FooterComponent {

  private final Page page;

  public FooterComponent(Page page) {
    this.page = page;
  }

  public Locator privacyPolicyLink() {
    return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Privacy Policy"));
  }

  public Locator termsOfUseLink() {
    return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Terms of Use"));
  }

  public Locator LinkedIn(){
    return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LinkedIn"));
  }

  public Locator Imprint(){
    return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Imprint"));
  }

  public Locator Email(){
    return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("info@jobich.ch"));
  }

  public Locator Feedback(){
    return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Feedback"));
  }

}