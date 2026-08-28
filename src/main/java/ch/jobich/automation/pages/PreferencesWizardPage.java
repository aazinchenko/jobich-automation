package ch.jobich.automation.pages;

import ch.jobich.automation.components.FooterComponent;
import ch.jobich.automation.enums.Canton;
import ch.jobich.automation.enums.Domain;
import ch.jobich.automation.enums.LanguageRegion;
import ch.jobich.automation.enums.LookingFor;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PreferencesWizardPage extends BasePage {

  public PreferencesWizardPage(Page page) {
    super(page);
  }

  public PreferencesWizardPage selectIndustry(Domain domain) {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(domain.label()).setExact(true)).click();
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

  public PreferencesWizardPage selectRegion(LanguageRegion languageRegion) {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(languageRegion.label()).setExact(true)).click();
    return this;
  }

  public PreferencesWizardPage selectWorkMode(LookingFor lookingFor) {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(lookingFor.label()).setExact(true)).click();
    return this;
  }

  public PreferencesWizardPage selectType(LookingFor lookingFor){
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(lookingFor.label())).click();
    return this;
  }

  public WizardResultsPage showJobs() {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Show jobs")).click();
    return new WizardResultsPage(page);
  }
  public FooterComponent footer() {
    return new FooterComponent(page);
  }
}