package ch.jobich.automation.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class FooterComponent {

  private final Page page;

  public FooterComponent(Page page) {
    this.page = page;
  }
  private Locator visible(Locator locator) {
    locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    return locator;
  }

  public Locator privacyPolicyLink() {
    return visible(page.locator("a[href='/privacy.html'][target='_blank']"));
    //return visible(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Privacy Policy")));
    //2 links for Privacy Policy found. We need the main to be tested.
  }

  public Locator termsOfUseLink() {
    return visible(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Terms of Use")));
  }

  public Locator LinkedInLink(){
    return visible(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LinkedIn")));
  }

  public Locator ImprintLink(){
    return visible(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Imprint")));
  }

  public Locator EmailLink(){
    return visible(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("info@jobich.ch")));
  }

  public Locator FeedbackLink(){
    return visible(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Feedback")));
  }
}