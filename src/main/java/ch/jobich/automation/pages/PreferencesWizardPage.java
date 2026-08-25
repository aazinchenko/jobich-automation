package ch.jobich.automation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PreferencesWizardPage extends BasePage {

  public PreferencesWizardPage(Page page) {
    super(page);
  }

  public PreferencesWizardPage selectIndustry(String label) {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(label).setExact(true)).click();
    return this;
  }

  public PreferencesWizardPage next() {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
    return this;
  }

  public PreferencesWizardPage back() {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back")).click();
    return this;
  }

  public PreferencesWizardPage selectRegion(String label) {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(label).setExact(true)).click();
    return this;
  }

  public PreferencesWizardPage selectWorkMode(String label) {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(label).setExact(true)).click();
    return this;
  }
  public WizardResultsPage showJobs() {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Show jobs")).click();
    return new WizardResultsPage(page);
  }
}